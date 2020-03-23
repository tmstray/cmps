package com.hx.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.config.Constants;
import com.hx.dao.SysUserMapper;
import com.hx.entity.SysUser;
import com.hx.model.MainDataModel;
import com.hx.service.SysUserService;
import com.hx.utils.page.object.BaseConditionVO;



/**
 *
 * @Description: 用户 业务层处理
 * @author Administrator
 * @date: 2019年12月24日下午2:26:09
 */
@Service
public class SysUserServiceImpl extends AbstractService<SysUser, Integer> implements SysUserService
{

    @Autowired
    private SysUserMapper userMapper;

    /**
     * 根据条件分页查询用户列表
     *
     * @param model 用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectUserList(MainDataModel model)
    {
        return userMapper.selectUserList(model);
    }

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByUserName(String userName)
    {
        return userMapper.selectUserByUserName(userName);
    }
    /**
     * 新增保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertUser(SysUser user)
    {
        // 新增用户信息
        int rows = userMapper.insertUser(user);
        return rows;
    }

    /**
     * 校验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    @Override
    public String checkUserNameUnique(String userName)
    {
        int count = userMapper.checkUserNameUnique(userName);
        if (count > 0)
        {
            return Constants.NOT_UNIQUE;
        }
        return Constants.UNIQUE;
    }

    /**
     * 修改保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateUser(SysUser user)
    {
        return userMapper.updateUser(user);
    }


    /**
     * 通过用户ID删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public int deleteUserById(Long userId)
    {
        return userMapper.deleteUserById(userId);
    }

	@Override
	public void setBaseMapper() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageInfo<SysUser> selectForPage(BaseConditionVO baseConditionVO) {
		
		PageHelper.startPage(baseConditionVO.getPageNum(), baseConditionVO.getPageSize()); //设置每页的记录数
        List<SysUser> list = userMapper.selectBySelective(); //获取列表信息
        return new PageInfo<>(list);
	}

	@Override
	public List<SysUser> selectBySelective() {
		return null;
	}

	@Override
	public PageInfo<SysUser> selectForPage(SysUser reccord, BaseConditionVO baseConditionVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysUser> selectBySelective(SysUser friend) {
		// TODO Auto-generated method stub
		return null;
	}

}
