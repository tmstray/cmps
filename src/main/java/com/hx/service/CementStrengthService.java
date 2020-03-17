package com.hx.service;

import com.github.pagehelper.PageInfo;
import com.hx.entity.CementStrength;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CementStrengthService {
    //pageNum 当前页  pageSize 每页的数量  size 当前页的数量
    PageInfo<CementStrength> findByPage(Integer pageNum, Integer pageSize,Integer status,String sampleNo);
    boolean dataSynchronize();

    boolean saveOrUpdate(List<CementStrength> list);

    boolean createFile(String[] ids);
}
