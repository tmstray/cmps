package com.hx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *用户信息实体
 *
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long userId;

    /** 用户账号 */
    private String userName;

    /** 用户昵称 */
    private String nickName;

    /** 手机号码 */
    private String phoneNumber;

    /** 密码 */
    private String password;

    /** 菜单ID */
    private String menuId;

    /** 菜单名称 */
    private String menuName;

    /** 帐号状态（0正常 1停用） */
    private String status;

    /** 创建者  */
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /** 更新者 */
    private String updateBy;

    /** 更新时间*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    /** 删除标志 */
    private Integer deleteFlag;

    /** 备注 */
    private String remarks;
}
