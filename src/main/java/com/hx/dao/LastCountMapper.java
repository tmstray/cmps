package com.hx.dao;

import com.hx.entity.LastCount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LastCountMapper {
    public LastCount getLastCount();

    //根据id更新记录
    public int updateSelectiveById(LastCount newCount);

    public int insert(LastCount newCount);
}
