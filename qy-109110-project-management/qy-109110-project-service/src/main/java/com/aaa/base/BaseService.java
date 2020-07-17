package com.aaa.base;


import com.aaa.utils.Map2BeanUtils;
import com.aaa.utils.SpringContextUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.aaa.staticproperties.OrderStatic.*;

/**
 * 功能描述: <br>
 * 〈〉通用service
 *  *      这个service中封装了很多的通用方法:
 *  *          insert
 *  *          update
 *  *          delete
 *  *          select
 *  *          ...
 * @Param:
 * @Return:
 * @Author: lp123456
 * @Date: 2020/7/9 17:07
 */
public abstract class BaseService<T> {
    private Class<T> cache=null;
    @Autowired
    private Mapper<T> mapper;
    protected Mapper getMapper(){
        return mapper;
    }
    /**
     * 功能描述: <br>
     * 〈〉新增
     * @Param: [t]
     * @Return: java.lang.Integer
     * @Author: lp123456
     * @Date: 2020/7/9 17:11
     */
    public Integer add(T t){
        return mapper.insert(t);
    }
    /**
     * 功能描述: <br>
     * 〈〉根据主键进行删除
     * @Param: [t]
     * @Return: java.lang.Integer
     * @Author: lp123456
     * @Date: 2020/7/9 17:12
     */
    public Integer delete(T t){
        return mapper.deleteByPrimaryKey(0);
    }
    /**
     * 功能描述: <br>
     * 〈〉根据主键批量删除
     * @Param: [ids]
     * @Return: java.lang.Integer
     * @Author: lp123456
     * @Date: 2020/7/9 17:24
     */
    public Integer deleteByIds(List<Integer> ids ){
        /**
         * delete * from user where 1 = 1 and id in (1,2,3,4,5,6,7,8)
         * andIn("id")--->id就是数据库中的主键名称
         */
        Example example=Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id",ids)).build();
        return mapper.deleteByExample(example);
    }
    /**
     * 功能描述: <br>
     * 〈〉更新操作
     * @Param: [t]
     * @Return: java.lang.Integer
     * @Author: lp123456
     * @Date: 2020/7/9 17:26
     */
    public Integer update(T t){
        return mapper.updateByPrimaryKeySelective(t);
    }
    /**
     * 功能描述: <br>
     * 〈〉 update username = ?  from user where id in (1,2,3,4,5,6,7)
     * @Param: [t, ids]
     * @Return: java.lang.Integer
     * @Author: lp123456
     * @Date: 2020/7/9 17:31
     */
    public Integer batchUpdate(T t,Integer[] ids){
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t,example);
    }/**
     * 功能描述: <br>
     * 〈〉 查询一条数据
     *      *      形参中的t所传递的数据--->主键，唯一键(username, phone number....)
     * @Param: [t]
     * @Return: T
     * @Author: lp123456
     * @Date: 2020/7/9 17:33
     */
    public T selectOne(T t){
        return mapper.selectOne(t);
    }/**
     * 功能描述: <br>
     * 〈〉 通过条件查询一个列表
     * @Param: [where, orderByFiled, fileds]
     * @Return: T
     * @Author: lp123456
     * @Date: 2020/7/9 17:41
     */
    public T selectOneByFiled(Sqls where, String orderByFiled, String... fileds) {
        return (T) selectByFileds(null, null, where, orderByFiled, null, fileds).get(0);
    }
    /**
     * 功能描述: <br>
     * 〈〉实现条件查询的分页
     * @Param: [pageNo, pageSize, where, orderFiled, fileds]
     * @Return: com.github.pagehelper.PageInfo<T>
     * @Author: lp123456
     * @Date: 2020/7/9 17:42
     */
    public PageInfo<T> selectListByPageAndFiled(Integer pageNo, Integer pageSize, Sqls where, String orderFiled, String... fileds) {
        return new PageInfo<T>(selectByFileds(pageNo, pageSize, where, orderFiled, null, fileds));
    }
    /**
     * 功能描述: <br>
     * 〈〉查询集合，条件查询
     * @Param: [t]
     * @Return: java.util.List<T>
     * @Author: lp123456
     * @Date: 2020/7/9 17:43
     */
    public List<T> selectList(T t){
        return mapper.select(t);
    }/**
     * 功能描述: <br>
     * 〈〉查询集合，分页查询
     * @Param: [t, pageNo, pageSize]
     * @Return: com.github.pagehelper.PageInfo<T>
     * @Author: lp123456
     * @Date: 2020/7/9 17:46
     */
    public PageInfo<T> selectListByPage(T t,Integer pageNo,Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<T> select =mapper.select(t);
        PageInfo<T> pageInfo=new PageInfo<T>(select);
        return pageInfo;
    }

    /**
     * 功能描述: <br>
     * 〈〉 Map转换实体类型
     * @Param: [map]
     * @Return: T
     * @Author: lp123456
     * @Date: 2020/7/9 17:49
     */
    public T newInstance(Map map){
        return (T) Map2BeanUtils.map2Bean(map,getTypeArguement());
    }
    /**
     * 功能描述: <br>
     * 〈〉实现查询通用
     *      *          不但可以作用于分页，还可以作用于排序，还能作用于多条件查询
     *      *      orderByFiled:是所要排序的字段
     * @Param: [pageNo, pageSize, where, orderByFiled, orderWord, fileds]
     * @Return: java.util.List<T>
     * @Author: lp123456
     * @Date: 2020/7/9 17:41
     */
    private List<T> selectByFileds(Integer pageNo, Integer pageSize, Sqls where, String orderByFiled, String orderWord, String... fileds) {
        Example.Builder builder = null;
        if(null == fileds || fileds.length == 0) {
            // 查询所有数据
            builder = Example.builder(getTypeArguement());
        } else {
            // 说明需要进行条件查询
            builder = Example.builder(getTypeArguement()).select(fileds);
        }
        if(where != null) {
            // 说明有用户自定义的where语句条件
            builder = builder.where(where);
        }
        if(orderByFiled != null) {
            // 说明我需要对某个字段进行排序
            if(DESC.equals(orderWord.toUpperCase())) {
                // 说明需要倒序
                builder = builder.orderByDesc(orderByFiled);
            } else if(ASC.equals(orderWord.toUpperCase())) {
                builder = builder.orderByAsc(orderByFiled);
            } else {
                builder = builder.orderByDesc(orderByFiled);
            }
        }
        Example example = builder.build();
        // 实现分页
        if(pageNo != null & pageSize != null) {
            PageHelper.startPage(pageNo, pageSize);
        }
        return getMapper().selectByExample(example);
    }
    /**
     * 功能描述: <br>
     * 〈〉 获取子类泛型类型
     * @Param: []
     * @Return: java.lang.Class<T>
     * @Author: lp123456
     * @Date: 2020/7/9 17:52
     */
    public Class<T> getTypeArguement(){
        if (null ==cache){
            cache = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return cache;
    }
    /**
     * 功能描述: <br>
     * 〈〉获取spring容器/获取spring的上下文
     *      *      在项目开始运行的时候，会去加载spring配置，
     *      *      如果你们项目需要在项目启动的时候也加载自己的配置文件
     *      *      在spring的源码中有一个必须要看的方法(init())
     *      *      init()--->就是在项目启动的时候去加载spring的配置
     *      *       如果你的项目中也需要把某一些配置一开始就托管给spring
     *      *       需要获取到spring的上下文(ApplicationContext)
     * @Param: []
     * @Return: org.springframework.context.ApplicationContext
     * @Author: lp123456
     * @Date: 2020/7/9 17:53
     */
    public ApplicationContext getApplicationContext(){
        return SpringContextUtils.getApplicationContext();
    }

}
