package com.aaa.redis;

import com.aaa.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisCluster;

import javax.annotation.PostConstruct;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static com.aaa.staticproperties.RedisProperties.*;

//@Service
public class RedisService<T> {


    private RedisSerializer keySerializer=null;
    /**
     * 功能描述: <br>
     * 〈〉初始化redis的key序列器
     * @Param: []
     * @Return: void
     * @Author: lp123456
     * @Date: 2020/7/13 15:05
     */
    @PostConstruct
    public void initRedisSerializer(){
        if (this.keySerializer==null){
            this.keySerializer=new  JdkSerializationRedisSerializer(this.getClass().getClassLoader());

        }

    }
    @Autowired
    private JedisCluster jedisCluster;
    /**
     * 功能描述: <br>
     * 〈〉 向redis中存入数据
     *      *      nxxx:
     *      *          是固定值，有两个值
     *      *          "nx":
     *      *              如果redis中的key不存在，则就可以存储，如果redis中已经有这个key了，则不存数据
     *      *          "xx":
     *      *              如果redis中的key存在，则直接覆盖，如果key不存在则不存
     *      *
     *      *      eg:
     *      *          研发组有两个人，一个是张三，一个是李四
     *      *          张三负责商品管理的代码编写
     *      *          李四负责订单管理
     *      *          张三和李四因为数据量过大都会使用到redis
     *      *          张三---->redis.set("goods", 商品信息);
     *      *          李四---->redis.set("goods", 订单信息);
     *      *          张三---->redis.get("goods")--->订单信息---->转换异常
     *      *
     *      *          张三负责商品管理的代码编写
     *      *              张三---->redis.set("goods", 商品信息);
     *      *              张三---->redis.set("goods", 商品信息);
     *      *
     *      *     expx:
     *      *      值也是固定的
     *      *      只有两个值:
     *      *          ex:
     *      *              失效时间的单位是秒
     *      *          px:
     *      *              失效时间的单位是毫秒
     *      *
     *      *     seconds:
     *      *          失效时间
     *      *
     *      *
     * @Param: [key, value, nxxx, expx, seconds]
     * @Return: java.lang.String
     * @Author: lp123456
     * @Date: 2020/7/13 15:28
     */
    public String set(String key,T value,String nxxx,String expx,Integer seconds){
        if (null !=seconds && 0<seconds &&
                (EX.equals(expx)||PX.equals(expx)) &&
                (XX.equals(nxxx)||NX.equals(nxxx))){
            //说明在存入数据的时候我就必须要上失效时间了
            return jedisCluster.set(key, JSONUtils.toJsonString(value),nxxx,expx,seconds);
        } else {
            // 说明不需要设置失效时间
            // 但是仍然需要进一步去判断用户所传递到底nx还是xx
            if (NX.equals(nxxx)){
                return String.valueOf(jedisCluster.setnx(key, JSONUtils.toJsonString(value)));

            }else if (XX.equals(nxxx)){
                return jedisCluster.set(key,JSONUtils.toJsonString(value));
            }
        }
        return NO;
    }
    /**
     * 功能描述: <br>
     * 〈〉从redis中查询数据(单个的
     * @Param: [key]
     * @Return: T
     * @Author: lp123456
     * @Date: 2020/7/13 15:34
     */
    public T getOne(String key){
        return (T) JSONUtils.toObject(jedisCluster.get(key),Object.class);
    }
    /**
     * 功能描述: <br>
     * 〈〉从redis中查询数据(value值得字符串
     * @Param: [key]
     * @Return: java.lang.String
     * @Author: lp123456
     * @Date: 2020/7/13 15:36
     */
    public String getString(String key){
        return jedisCluster.get(key);
    }
    /**
     * 功能描述: <br>
     * 〈〉从redis中查询数据(集合查询
     * @Param: [key]
     * @Return: java.util.List<T>
     * @Author: lp123456
     * @Date: 2020/7/13 15:41
     */
    public List<T> getList(String key){
        return (List<T>)JSONUtils.toList(jedisCluster.get(key),Object.class);
    }
      /**
       * 功能描述: <br>
       * 〈〉删除redis中的一条数据
       * @Param: [key]
       * @Return: java.lang.Long
       * @Author: lp123456
       * @Date: 2020/7/13 15:44
       */
    public Long delOne (Object key){
        /**
         * 思路:
         *  目前来说架构遇到的问题:
         *      封装redis的时候发现无法实现通用，因为JedisCluster只能接收String类型key值
         *      并不符合架构标准，最终可以把Object对象转换为字节数组来进行处理这个问题
         */
        return jedisCluster.del(rawKey(key));
    }
    public Long delMany(Collection<T> keys){
        if (CollectionUtils.isEmpty(keys)){
            return 0L;
        }else{
            byte[][] bytes=this.rawkeys(keys);
            return jedisCluster.del(bytes);
        }
    }
    private byte[] rawKey(Object key){
        Assert.notNull(key,"non null key required");
        return this.keySerializer==null && key instanceof byte[] ?
                (byte[]) key :this.keySerializer.serialize(key);
    }
    private byte[][] rawkeys(Collection<T> keys){
        byte[][] rks=new byte[keys.size()][];
        int i =0;
        Object key;
        for (Iterator i9 =keys.iterator();i9.hasNext();rks[i++]=this.rawKey(key)){
            key =i9.next();
        }
        return rks;
    }
}
