package com.aaa.controller;

import com.aaa.base.BaseController;
import com.aaa.base.ResultData;
import com.aaa.model.Dict;
import com.aaa.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictController extends BaseController {
    @Autowired
    private IProjectService projectService;
    @PostMapping("/selectAllDict")
    public ResultData selectAllDict (@RequestBody Dict dict, @RequestParam Integer pageNo, @RequestParam Integer pageSize){
        return projectService.selectAllDict(dict,pageNo,pageSize);
    }
}
