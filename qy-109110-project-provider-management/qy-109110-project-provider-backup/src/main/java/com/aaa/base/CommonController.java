package com.aaa.base;

import com.github.pagehelper.PageInfo;
import org.apache.http.protocol.RequestDate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class CommonController<T> extends BaseController {
    /**
     * 功能描述: <br>
     * 〈〉钩子函数
     *      *      在新增之前去执行某些操作
     *      *
     *      *      下单操作:
     *      *          需求
     *      *              在购物车中当点击立即下单按钮的时候--->跳转下单页面(选择地址，选择优惠券...)
     *      *              把购物车中的这个商品删除
     *      *              deleteCart(List<Integer> id);--->是优先于insertOrder前置执行
     *      *
     *      *          insertOrder(Order oder);
     * @Param: [map]
     * @Return: void
     * @Author: lp123456
     * @Date: 2020/7/9 17:58
     */
    protected void beforeAdd(Map map){

    }
    /**
     * 功能描述: <br>
     * 〈〉钩子函数
     *      *      是在新增之后去执行
     *      *
     *      *      int result = insertOrder(Order order)
     *      *      if(result > 0) {
     *      *          insertOrderDetail(OrderDetail orderDetail);
     *      *      }
     * @Param: [map]
     * @Return: void
     * @Author: lp123456
     * @Date: 2020/7/9 17:59
     */
    protected void afterAdd(Map map){

    }
    public abstract BaseService<T> getBaseService();
    /**
     * 功能描述: <br>
     * 〈〉 通用的新增方法
     *      *      因为咱们目前市面上所有的公司实现的全是异步了
     *      *      也就是说前端向后端所传递的数据都是json格式
     *      *      之前在controller的方法中接收固定的实体类，是因为你知道前端给你传递的类型就是这个实体类
     *      *      但是既然要做通用，前端所传递的类型就不会固定了--->所以使用Map类型来统一接收
     * @Param: []
     * @Return: com.aaa.base.BaseService<T>
     * @Author: lp123456
     * @Date: 2020/7/9 18:12
     */
     public ResultData add(@RequestBody Map map){
       beforeAdd(map);
       T instance = getBaseService().newInstance(map);
       Integer addResult = getBaseService().add(instance);
       if (addResult>0){
           afterAdd(map);
           return super.operationSuccess();
       }
       return super.operationFailed();

     }
     /**
      * 功能描述: <br>
      * 〈〉 删除操作
      * @Param: [map]
      * @Return: com.aaa.base.ResultData
      * @Author: lp123456
      * @Date: 2020/7/9 18:17
      */
     public ResultData delete(@RequestBody Map map){
         T instance =getBaseService().newInstance(map);
         Integer deleteResult=getBaseService().delete(instance);
         if (deleteResult>0){
             return super.operationSuccess();

         }
         return super.operationFailed();
     }
     /**
      * 功能描述: <br>
      * 〈〉   批量删除
      * @Param: [ids]
      * @Return: com.aaa.base.ResultData
      * @Author: lp123456
      * @Date: 2020/7/9 18:20
      */
     public ResultData batchDelete(@RequestParam("id[]") Integer[] ids){
         Integer deleteResult=getBaseService().deleteByIds(Arrays.asList(ids));
         if (deleteResult>0){
             return super.operationSuccess();
         }
         return super.operationFailed();
     }
     /**
      * 功能描述: <br>
      * 〈〉更新
      * @Param: [map]
      * @Return: com.aaa.base.ResultData
      * @Author: lp123456
      * @Date: 2020/7/10 16:30
      */
     public ResultData update (@RequestBody Map map) {
         T t = getBaseService().newInstance(map);
         int updateResult = getBaseService().update(t);
         if (updateResult >0) {
             return operationSuccess();
         }
         return operationFailed();
     }
     /**
      * 功能描述: <br>
      * 〈〉插询一条数据
      * @Param: [map]
      * @Return: com.aaa.base.ResultData
      * @Author: lp123456
      * @Date: 2020/7/10 16:35
      * */

     public ResultData getOne(@RequestBody Map map){
         T t = getBaseService().newInstance(map);
         t = getBaseService().selectOne(t);
         if (null !=t){
             return operationSuccess();
         }
         return operationFailed();
     }/**
      * 功能描述: <br>
      * 〈〉条件查询多条结果
      * @Param: [map]
      * @Return: com.aaa.base.ResultData
      * @Author: lp123456
      * @Date: 2020/7/10 16:45
      */
     public ResultData getList(@RequestBody Map map){
         T t = getBaseService().newInstance(map);
         List<T> resultT = getBaseService().selectList(t);
         if (resultT.size()>0){
             return operationSuccess(resultT);
         }
         return operationFailed("未找到查询结果");
     }
     /**
      * 功能描述: <br>
      * 〈〉带条件的分页查询
      * @Param: [map, pageNo, pageSize]
      * @Return: com.aaa.base.ResultData
      * @Author: lp123456
      * @Date: 2020/7/10 16:56
      */
     public ResultData getListByPage(@RequestBody Map map,@RequestParam("pageNo")int pageNo,@RequestParam("pageSize") int pageSize){
         T t = getBaseService().newInstance(map);
         PageInfo<T> pageInfo = getBaseService().selectListByPage(t, pageNo, pageSize);
         List<T> resultList = pageInfo.getList();
         if (resultList.size()>0){
             return operationSuccess(pageInfo);
         }
         return operationFailed("没有查到数据");
     }
     /**
      * 功能描述: <br>
      * 〈〉不带条件的分页查询
      * @Param: [pageNo, pageSize]
      * @Return: com.aaa.base.ResultData
      * @Author: lp123456
      * @Date: 2020/7/10 17:01
      */
    public ResultData getListByPage(@RequestParam("pageNo")int pageNo,@RequestParam("pageSize") int pageSize){

        PageInfo<T> pageInfo = getBaseService().selectListByPage(null, pageNo, pageSize);
        List<T> resultList = pageInfo.getList();
        if (resultList.size()>0){
            return operationSuccess(pageInfo);
        }
        return operationFailed("没有查到数据");
    }/**
     * 功能描述: <br>
     * 〈〉从本地线程中获取request对象
     * @Param: []
     * @Return: javax.servlet.http.HttpServletRequest
     * @Author: lp123456
     * @Date: 2020/7/10 17:06
     */
    public HttpServletRequest getServletRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes;
        if (requestAttributes instanceof ServletRequestAttributes){
            servletRequestAttributes =(ServletRequestAttributes) requestAttributes;
            return servletRequestAttributes.getRequest();
        }
        return null;
    }
    /**
     * 功能描述: <br>
     * 〈〉获取当前客户端session对象(如果没有就创建新的)
     * @Param: []
     * @Return: javax.servlet.http.HttpSession
     * @Author: lp123456
     * @Date: 2020/7/10 17:08
     */
    public HttpSession getSession(){
        return getServletRequest().getSession();
    }
    /**
     * 功能描述: <br>
     * 〈〉获取当前客户端session对象(如果没有就返回null
     * @Param:
     * @Return:
     * @Author: lp123456
     * @Date: 2020/7/10 17:09
     */
    public HttpSession getExitSession(){
        return getServletRequest().getSession(false);
    }

}
