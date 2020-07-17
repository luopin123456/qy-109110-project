package com.aaa.mapper;

import com.aaa.model.Dict;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DictMapper extends Mapper<Dict> {
    List<Dict> selectDictAny(Dict dict);
}