package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.LoginLog;
import com.aaa.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginLogController extends CommonController<LoginLog> {
    @Autowired
    private LoginLogService loginLogService;

    public BaseService<LoginLog> getBaseService() {
        return loginLogService;
    }
    @PostMapping("/doLoginLog")
    public Integer doLoginLog(@RequestBody LoginLog loginLog){
        return getBaseService().add(loginLog);
    }

}
