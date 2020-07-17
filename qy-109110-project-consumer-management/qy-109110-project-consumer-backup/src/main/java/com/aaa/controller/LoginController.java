package com.aaa.controller;


import com.aaa.anotation.LoginAnnotation;
import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.User;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController extends BaseController {
    @Autowired
    private IProjectService projectService;

    @PostMapping("/doLogin")
    @LoginAnnotation(opeationType = "登录操作", opeationName="管理员登录")
    public ResultData doLogin(@RequestBody User user){
        return projectService.doLogin(user);
    }
}
