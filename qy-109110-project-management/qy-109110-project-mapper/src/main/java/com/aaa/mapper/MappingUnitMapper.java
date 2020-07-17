package com.aaa.mapper;

import com.aaa.model.MappingUnit;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface MappingUnitMapper extends Mapper<MappingUnit> {
    List<MappingUnit> selectMappingUnitLike(String str);
}