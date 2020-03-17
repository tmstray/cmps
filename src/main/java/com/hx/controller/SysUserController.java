package com.hx.controller;


import com.hx.entity.SysUser;
import com.hx.service.SysUserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @Description: 用户管理
 * @author Administrator
 * @date: 2019年12月24日下午2:45:34
 */
@RestController
@RequestMapping("/system/user")
public class SysUserController
{
    @Autowired
    private SysUserService userService;


}
