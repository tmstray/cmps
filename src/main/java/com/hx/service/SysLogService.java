package com.hx.service;


import com.hx.entity.SysLog;
import com.hx.model.SysLogDataModel;

import java.util.List;

/**
 * 托盘管理操作日志Service接口
 *
 */
public interface SysLogService
{
    /**
     * 查询托盘管理操作日志
     *
     * @param id 托盘管理操作日志ID
     * @return 托盘管理操作日志
     */
    public SysLog selectSysLogById(Integer id);

    /**
     * 查询托盘管理操作日志列表
     *
     * @param model 托盘管理操作日志
     * @return 托盘管理操作日志集合
     */
    public List<SysLog> selectSysLogList(SysLogDataModel model);

    /**
     * 新增托盘管理操作日志
     *
     * @param SysLog 托盘管理操作日志
     * @return 结果
     */
    public int insertSysLog(SysLog SysLog);

    /**
     * 修改托盘管理操作日志
     *
     * @param SysLog 托盘管理操作日志
     * @return 结果
     */
    public int updateSysLog(SysLog SysLog);

    /**
     * 批量删除托盘管理操作日志
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysLogByIds(String ids);

    /**
     * 删除托盘管理操作日志信息
     *
     * @param id 托盘管理操作日志ID
     * @return 结果
     */
    public int deleteSysLogById(Long id);
}
