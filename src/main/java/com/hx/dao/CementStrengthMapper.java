package com.hx.dao;

import com.hx.entity.CementStrength;
import com.hx.entity.CementStrengthExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CementStrengthMapper {
    int countByExample(CementStrengthExample example);

    int deleteByExample(CementStrengthExample example);

    int deleteByPrimaryKey(Integer ID);

    int insert(CementStrength record);

    int insertSelective(CementStrength record);

    List<CementStrength> selectByExample(CementStrengthExample example);

    CementStrength selectByPrimaryKey(Integer ID);

    //根据样品编号和期龄查找记录条数
    int selectCountBySampleNo(@Param("sampleNo") String sampleNo,@Param("duration") String duration);

    //根据样品编号更新数据
    int updateBySampleNoSelective(@Param("sampleNo") String sampleNo, @Param("record") CementStrength data);

    int updateByExampleSelective(@Param("record") CementStrength record, @Param("example") CementStrengthExample example);

    int updateByExample(@Param("record") CementStrength record, @Param("example") CementStrengthExample example);

    int updateByPrimaryKeySelective(CementStrength record);

    int updateByPrimaryKey(CementStrength record);

    //根据id更新数据状态为已上传
    void updateStatusById(@Param("id") String id);
}