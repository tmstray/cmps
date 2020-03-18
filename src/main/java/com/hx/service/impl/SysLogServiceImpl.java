package com.hx.service.impl;

import com.hx.dao.SysLogMapper;
import com.hx.entity.SysLog;
import com.hx.model.MainDataModel;
import com.hx.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 托盘管理操作日志Service业务层处理
 *
 */
@Service
public class SysLogServiceImpl implements SysLogService
{
    @Autowired
    private com.hx.dao.SysLogMapper sysLogMapper;

    /**
     * 查询托盘管理操作日志
     *
     * @param id 托盘管理操作日志ID
     * @return 托盘管理操作日志
     */
    @Override
    public SysLog selectSysLogById(Integer id)
    {
        return null;
    }

    /**
     * 查询托盘管理操作日志列表
     *
     * @param model 托盘管理操作日志
     * @return 托盘管理操作日志
     */
    @Override
    public List<SysLog> selectSysLogList(MainDataModel model)
    {
        return sysLogMapper.selectSysLogList(model);
    }

    /**
     * 新增托盘管理操作日志
     *
     * @param SysLog 托盘管理操作日志
     * @return 结果
     */
    @Override
    public int insertSysLog(SysLog SysLog)
    {
        return sysLogMapper.insertSysLog(SysLog);
    }

    /**
     * 修改托盘管理操作日志
     *
     * @param SysLog 托盘管理操作日志
     * @return 结果
     */
    @Override
    public int updateSysLog(SysLog SysLog)
    {
        return 0;
    }

    /**
     * 删除托盘管理操作日志对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysLogByIds(String ids)
    {
            return 0;
    }

    /**
     * 删除托盘管理操作日志信息
     *
     * @param id 托盘管理操作日志ID
     * @return 结果
     */
    @Override
    public int deleteSysLogById(Long id)
    {
        return sysLogMapper.deleteByPrimaryKey(id);
    }
}
