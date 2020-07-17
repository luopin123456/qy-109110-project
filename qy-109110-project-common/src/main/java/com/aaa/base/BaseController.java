package com.aaa.base;

        import static com.aaa.status.LoginStatus.*;
        import static com.aaa.status.OperationStatus.*;

public class BaseController {
    /**
     * 功能描述: <br>
     * 〈〉登录陈功,系统提示
     * @Param: []
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/9 15:56
     * @param toke
     */
    protected ResultData loginSucces(String toke){
        ResultData resultData=new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }
    /**
     * 功能描述: <br>
     * 〈〉
     * 登录成功自定义信息
     * @Param: [msg]
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/9 16:03
     */
    protected ResultData logingSuccess(String msg){
        ResultData resultData=new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setCode(msg);
        return resultData;
    }
    /**
     * 功能描述: <br>
     * 〈〉登陆失败,系统消息加详细说明
     * @Param: [detail]
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/9 16:07
     */
    protected ResultData loginFailed(String detail){
        ResultData resultData=new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDatail(detail);
        return resultData;
    }
    /**
     * 功能描述: <br>
     * 〈〉操作成功.系统返回消息
     * @Param: []
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/9 16:12
     */
    protected ResultData operationSuccess(){
        ResultData resultData=new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        return resultData;
    }
    /**
     * 功能描述: <br>
     * 〈〉操作成功.返回系统或自定义信息
     * @Param: [data]
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/10 16:42
     */
    protected ResultData operationSuccess(Object data){
        ResultData resultData=new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * 功能描述: <br>
     * 〈〉操作失败.返回系统消息
     * @Param: []
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/9 16:14
     */
    protected ResultData operationFailed(){
        ResultData resultData=new ResultData();
        resultData.setMsg(FAILED.getMsg());
        resultData.setCode(FAILED.getCode());
        return resultData;
    }
    /**
     * 功能描述: <br>
     * 〈〉操作失败返回数据
     * @Param: [msg]
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/10 17:26
     */
    protected ResultData operationFailed(String msg){
        ResultData resultData=new ResultData();
        resultData.setMsg(FAILED.getMsg());
        resultData.setCode(FAILED.getCode());
        resultData.setData(msg);
        return resultData;
    }

    public static @interface LoginAnotation {
    }
}
