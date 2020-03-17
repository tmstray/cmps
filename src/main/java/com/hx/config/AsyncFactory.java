package com.hx.config;


import com.hx.entity.SysLog;
import com.hx.service.SysLogService;
import com.hx.utils.AddressUtils;
import com.hx.utils.SpringUtils;

import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 *
 */
public class AsyncFactory
{

    /**
     * 操作日志记录
     *
     * @param sysLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOper(final SysLog sysLog)
    {
        return new TimerTask()
        {
            @Override
            public void run()
            {
            	// 远程查询操作地点
//                sysLog.setIp(AddressUtils.getRealAddressByIP(sysLog.getIp()));
                SpringUtils.getBean(SysLogService.class).insertSysLog(sysLog);
            }
        };
    }
}

