package com.hx.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hx.entity.SysUser;
import com.hx.model.MainDataModel;

/**
 *
 * @Description:用户表 数据层
 * @author Administrator
 * @date: 2019年12月24日下午2:17:52
 */
//@Repository
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser, Integer>
{
	
	@Override
	List<SysUser> selectBySelective();
	
//	@Override
//	List<SysUser> selectBySelective(SysUser sysUser);
    /**
     * 根据条件分页查询用户列表
     *
     * @param model 用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectUserList(MainDataModel model);

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByUserName(String userName);


    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    public int insertUser(SysUser user);

    /**
     * 校验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    public int checkUserNameUnique(String userName);


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
