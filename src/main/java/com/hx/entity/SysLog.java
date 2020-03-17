package com.hx.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志 实体类
 */
@Data
public class SysLog  implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private Integer id;

    /** 业务模块名称 */
    private String businessModule;

    /** 业务类型（0其它 1新增 2修改 3删除 4数据同步 5 数据上传） */
    private Integer businessType;

    /** 操作方法 */
    private String method;

    /** 操作者IP */
    private String ip;

    /** 请求方式 */
    private String requestMethod;

    /** 操作状态（0正常 1异常） */
    private Integer status;

    /** 错误消息 */
    private String errorMsg;

    /** 备注 */
    private String remarks;

    /** 删除标志 */
    private Integer deleteFlag;

    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    private Date createTime;
}
