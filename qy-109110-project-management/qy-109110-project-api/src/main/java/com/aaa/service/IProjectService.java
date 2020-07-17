package com.aaa.service;

import com.aaa.base.ResultData;
import com.aaa.model.Dict;
import com.aaa.model.LoginLog;
import com.aaa.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "book-interface")
public interface IProjectService {
    /**
     * 功能描述: <br>
     * 〈〉执行登录操作
     * @Param: [user]
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/15 16:46
     */
    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody User user);
    @PostMapping("/doLoginLog")
    Integer doLoginLog(@RequestBody LoginLog loginLog);
/**
 * 功能描述: <br>
 * 〈〉字典的查询所有
 * @Param: [dict]
 * @Return: com.aaa.base.ResultData
 * @Author: lp123456
 * @Date: 2020/7/16 10:33
 */
    @PostMapping("/selectAllDict")
    ResultData selectAllDict(@RequestBody Dict dict, @RequestParam Integer pageNo, @RequestParam Integer pageSize);
}
