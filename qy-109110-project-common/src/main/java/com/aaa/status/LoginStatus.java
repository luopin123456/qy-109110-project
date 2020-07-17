package com.aaa.status;

public enum  LoginStatus {
    LOGIN_SUCCESS ("200","登录成功"),
    LOGIN_FAILED ("400","登陆失败.系统异常"),
    USER_EXIST("201","用户已处在"),
    USER_NOT_EXIST("401","用户不存在"),
    PASSWORD_WRONG("402","密码错误"),
    LOGIN_WRONG("405","用户退出异常"),
    SYSTEM_EXCEPTION("406","系统异常");

    private String msg;
    private String code;
    LoginStatus(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }
}
