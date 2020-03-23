package com.hx.service;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hx.utils.page.object.BaseConditionVO;

public interface BaseService<T, ID extends Serializable> {

    void setBaseMapper();

    int deleteByPrimaryKey(ID[] id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

    List<T> selectBySelective(T record);

    PageInfo<T> selectForPage(T reccord, BaseConditionVO baseConditionVO);
    PageInfo<T> selectForPage(BaseConditionVO baseConditionVO);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);
}
