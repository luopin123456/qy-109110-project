package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.User;
import com.aaa.service.LoginService;
import com.aaa.vo.TokeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.aaa.status.LoginStatus.*;

@RestController
public class loginController extends CommonController<User> {
    @Autowired
    private LoginService loginService;

    public BaseService getBaseService() {
        return loginService;
    }

    @PostMapping("/doLogin")
    public ResultData doLogin(@RequestBody User user){
        TokeVo tokeVo = loginService.doLogin(user);
        if (tokeVo.getIfSuccess()){
            return super.loginSucces(tokeVo.getToke());
        }else if (tokeVo.getType()==1){
            return super.loginFailed(USER_NOT_EXIST.getMsg());
        }else if (tokeVo.getType() == 2 ){
            return super.loginFailed(PASSWORD_WRONG.getMsg());
        }else {
            return super.loginFailed(SYSTEM_EXCEPTION.getMsg());
        }
    }


}
