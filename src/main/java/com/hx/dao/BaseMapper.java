package com.hx.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T, ID extends Serializable> {

    int deleteByPrimaryKey(ID[] id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

//    List<T> selectBySelective(T t);
    List<T> selectBySelective();

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);


}
