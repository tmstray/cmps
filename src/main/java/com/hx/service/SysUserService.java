package com.hx.service;

import com.hx.entity.SysUser;
import com.hx.model.MainDataModel;

import java.util.List;

/**
 *
 * @Description: 用户 业务层
 * @author Administrator
 * @date: 2019年12月24日下午2:19:37
 */
public interface SysUserService
{
    /**
     * 根据条件分页查询用户列表
     *
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    List<SysUser> selectUserList(SysUser user);

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int insertUser(SysUser user);

    /**
     * 修改用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int updateUser(SysUser user);

    /**
     * 通过用户ID删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteUserById(Long userId);

}
