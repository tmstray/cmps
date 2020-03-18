package com.hx.dao;


import com.hx.entity.SysLog;
import com.hx.model.MainDataModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysLogMapper {

    List<SysLog> selectSysLogList(MainDataModel model);

    int deleteByPrimaryKey(Long id);

    /**
     * 新增托盘管理操作日志
     *
     * @param sysLog 托盘管理操作日志
     * @return 结果
     */
    int insertSysLog(SysLog sysLog);

    int insertSelective(SysLog record);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);
}
