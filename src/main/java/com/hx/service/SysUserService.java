package com.hx.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hx.entity.SysUser;
import com.hx.model.MainDataModel;
import com.hx.utils.page.object.BaseConditionVO;

/**
 *
 * @Description: 用户 业务层
 * @author Administrator
 * @date: 2019年12月24日下午2:19:37
 */
public interface SysUserService extends BaseService<SysUser, Integer>
{
	@Override
	List<SysUser> selectBySelective(SysUser friend);
	
	List<SysUser> selectBySelective();
	
    /**
     * 根据条件分页查询用户列表
     *
     * @param model 用户信息
     * @return 用户信息集合信息
     */
    List<SysUser> selectUserList(MainDataModel model);


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

    /**
     * 校验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    public String checkUserNameUnique(String userName);


	PageInfo<SysUser> selectForPage(BaseConditionVO baseConditionVO);
}
