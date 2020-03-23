package com.hx.service.impl;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.dao.BaseMapper;
import com.hx.service.BaseService;
import com.hx.utils.page.object.BaseConditionVO;

public abstract class AbstractService<T, ID extends Serializable> implements BaseService<T, ID> {

    private BaseMapper<T, ID> baseMapper;

    //初始化baseMapper
    public void setBaseMapper(BaseMapper<T, ID> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public int deleteByPrimaryKey(ID[] id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(T record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public T selectByPrimaryKey(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }

//    @Override
//    public List<T> selectBySelective(T record) {
//        return baseMapper.selectBySelective(record);
//    }

//    @Override
//    public PageInfo<T> selectForPage(T record, BaseConditionVO baseConditionVO) {
//        PageHelper.startPage(baseConditionVO.getPageNum(), baseConditionVO.getPageSize()); //设置每页的记录数
//        List<T> list = baseMapper.selectBySelective(); //获取列表信息
//        return new PageInfo<>(list);
//    }
    
    @Override
    public PageInfo<T> selectForPage(BaseConditionVO baseConditionVO) {
        PageHelper.startPage(baseConditionVO.getPageNum(), baseConditionVO.getPageSize()); //设置每页的记录数
        List<T> list = baseMapper.selectBySelective(); //获取列表信息
        System.out.println(111111);
        return new PageInfo<>(list);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(T record) {
        return baseMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insert(T record) {
        return baseMapper.insert(record);
    }
}
