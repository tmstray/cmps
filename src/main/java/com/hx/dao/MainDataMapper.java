package com.hx.dao;

import com.hx.entity.MainData;
import com.hx.model.MainDataModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainDataMapper {
    int deleteByPrimaryKey(String id);

    int insert(MainData record);

    int insertSelective(MainData record);

    MainData selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MainData record);

    int updateByPrimaryKey(MainData record);

    List<MainData> findByPage(MainDataModel model);

    //根据样品编号查找记录条数
    int selectCountBySampleNo(String sampleNo);

    //检查数据完整性
    MainData checkBySampleNo(String sampleNo);

    MainData checkBySampleNoForSimpled(String sampleNo);

    //根据样品编号更新数据
    int updateBySampleNoSelective(@Param("sampleNo") String sampleNo, @Param("data") MainData data);

    //更新status状态1-数据完整待上传2-已上传
    int updateStatus(@Param("sampleNo") String sampleNo, @Param("status") Integer status);

    //根据id更新数据状态为已上传
    int updateStatusById(@Param("id") String id);

    //更新数据后异常清楚之前计算结果
    int clearResultById(MainData record);
}
