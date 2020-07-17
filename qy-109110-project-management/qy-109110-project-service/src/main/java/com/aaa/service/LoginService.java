package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.model.User;
import com.aaa.vo.TokeVo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginService extends BaseService<User> {
    public TokeVo doLogin(User user){
        TokeVo tokeVo = new TokeVo();
        User user1=new User();
        if(user!=null){
            user1.setUsername(user.getUsername());
            User user2 = super.selectOne(user1);
            if (user2==null){
                tokeVo.setIfSuccess(false).setType(1);
                return tokeVo;
            }else {
                user1.setPassword(user.getPassword());
                User user3=super.selectOne(user1);
                if (null==user3){
                    tokeVo.setIfSuccess(false).setType(2);
                    return tokeVo;
                }else {
                    String token = UUID.randomUUID().toString().replaceAll("-","");
                    user3.setToken(token);
                    Integer updateResult=super.update(user3);
                    if(updateResult>0){
                        tokeVo.setIfSuccess(true).setToke(token);
                    }else {
                        tokeVo.setIfSuccess(false).setType(4);
                        return tokeVo;
                    }
                }
            }
        }else {
            tokeVo.setIfSuccess(false).setType(4);
            return tokeVo;
        }
        return tokeVo;
    }
}
