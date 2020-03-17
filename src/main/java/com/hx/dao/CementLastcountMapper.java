package com.hx.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.hx.entity.CementLastcount;
import com.hx.entity.CementLastcountExample;

@Repository
@Mapper
public interface CementLastcountMapper {
    int countByExample(CementLastcountExample example);

    int deleteByExample(CementLastcountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CementLastcount record);

    int insertSelective(CementLastcount record);

    public CementLastcount getLastCount();

    List<CementLastcount> selectByExample(CementLastcountExample example);

    CementLastcount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CementLastcount record, @Param("example") CementLastcountExample example);

    int updateByExample(@Param("record") CementLastcount record, @Param("example") CementLastcountExample example);

    int updateByPrimaryKeySelective(CementLastcount record);

    int updateByPrimaryKey(CementLastcount record);
}