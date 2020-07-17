package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.Dict;
import com.aaa.service.DictService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class DictController extends CommonController<Dict> {

    @Autowired
    private DictService dictService;


    public BaseService<Dict> getBaseService() {
        return dictService;
    }

/**
 * 功能描述: <br>
 * 〈〉分页查询
 * @Param: [dict, pageNo, pageSize]
 * @Return: com.aaa.base.ResultData
 * @Author: lp123456
 * @Date: 2020/7/16 15:31
 */
    @PostMapping("/selectAllDict")
    public ResultData selectAllDict(@RequestBody Dict dict,@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        ResultData resultData=new ResultData();

        System.out.println(pageNo +pageSize);
        return resultData.setData(getBaseService().selectListByPage(dict,pageNo,pageSize));
    }
    /**
     * 功能描述: <br>
     * 〈〉新增
     * @Param: [dict]
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/16 15:40
     */
    @PostMapping("/addDict")
    public ResultData addDict(@RequestBody Dict dict){
        ResultData resultData=new ResultData();
        Integer i=getBaseService().add(dict);
        if (i<1){
            return super.operationSuccess();
        }else {
            return null;
        }


    }
    /**
     * 功能描述: <br>
     * 〈〉根据主键删除
     * @Param: [dict]
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/16 15:40
     */
    @PostMapping("/delDict")
    public ResultData delDict(@RequestBody Dict dict){
        ResultData resultData=new ResultData();
        return resultData.setData( getBaseService().delete(dict));

    }
    /**
     * 功能描述: <br>
     * 〈〉修改
     * @Param: [dict]
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/16 15:40
     */
    @PostMapping("/updateDict")
    public ResultData updateDict(@RequestBody Dict dict){
        ResultData resultData=new ResultData();
        return resultData.setData( getBaseService().add(dict));

    }
}
