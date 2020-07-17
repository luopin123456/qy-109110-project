package com.aaa.controller;

import com.aaa.base.BaseService;
import com.aaa.base.CommonController;
import com.aaa.base.ResultData;
import com.aaa.model.MappingUnit;
import com.aaa.service.MappingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MappingUnitController extends CommonController<MappingUnit> {
    @Autowired
    private MappingUnitService mappingUnitService;

    public BaseService<MappingUnit> getBaseService() {
        return mappingUnitService;
    }

    /**
     * 功能描述: <br>
     * 〈〉分页查询所有单位信息
     * @Param: [mappingUnit]
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/16 17:11
     */
    @RequestMapping("/selectAllMappingUnit")
    public ResultData selectAllMappingUnit(@RequestBody MappingUnit mappingUnit, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        ResultData resultData=new ResultData();
        return resultData.setData(getBaseService().selectListByPage(mappingUnit,pageNo,pageSize));
    }
    /**
     * 功能描述: <br>
     * 〈〉根据唯一字段查询
     * @Param: [mappingUnit]
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/16 18:23
     */
    @RequestMapping("/selectByMappingUnit")
    public ResultData selectByMappingUnit(@RequestBody MappingUnit mappingUnit){
        ResultData resultData=new ResultData();
        return resultData.setData(getBaseService().selectList(mappingUnit));
    }
    /**
     * 功能描述: <br>
     * 〈〉根据主键删除
     * @Param: [mappingUnit]
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/16 18:28
     */
    @RequestMapping("/delByMappingUnitId")
    public ResultData delByMappingUnitId(@RequestBody MappingUnit mappingUnit){
        ResultData resultData=new ResultData();
        return resultData.setData(getBaseService().delete(mappingUnit));
    }
    /**
     * 功能描述: <br>
     * 〈〉根据主键进行多个删去
     * @Param: [ids]
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/16 18:52
     */
    @RequestMapping("/delByMappingUnitManyId")
    public ResultData delByMappingUnitManyId(@RequestParam("ids") List ids){
        ResultData resultData=new ResultData();
        return resultData.setData(getBaseService().deleteByIds(ids));
    }
    /**
     * 功能描述: <br>
     * 模糊查询不能用实体类封装
     * @Param: [mappingUnit]
     * @Return: com.aaa.base.ResultData
     * @Author: lp123456
     * @Date: 2020/7/16 20:37
     */
    @PostMapping("/selectMappingUnitLike")
    public ResultData selectMappingUnitLike (@RequestParam("unit") String str){
        ResultData resultData=new ResultData();
        return resultData.setData(mappingUnitService.selectMappingUnitLike(str));
    }

}
