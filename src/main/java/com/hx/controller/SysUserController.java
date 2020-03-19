package com.hx.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.config.Constants;
import com.hx.config.Log;
import com.hx.entity.MainData;
import com.hx.entity.SysLog;
import com.hx.entity.SysUser;
import com.hx.entity.User;
import com.hx.model.BusinessType;
import com.hx.model.MainDataModel;
import com.hx.model.Response;
import com.hx.service.SysUserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @Description: 用户管理
 * @author Administrator
 * @date: 2020 03 17 17:48
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class SysUserController
{
    @Autowired
    private SysUserService userService;

    @Resource
    HttpSession httpSession;

    @GetMapping(value = "/getByUser")
    public ModelAndView findByPage(MainDataModel model){

        Page<MainData> page = PageHelper.startPage(model.getPageNum(),model.getPageSize());
        List<SysUser> dataList = userService.selectUserList(model);
        log.info("size:" + dataList.size());
        PageInfo<SysUser> pageInfo = new PageInfo<>(dataList);
        ModelAndView mv = new ModelAndView("user");
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("requestModel",model);
        return mv;
    }
    

    /**
     * 分页数据查询：
     * @param model
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/getDataByPage")
    public Response getDataByPage(MainDataModel model){
        Response response = null;
        try {
            Page<MainData> page = PageHelper.startPage(model.getPageNum(),model.getPageSize());
            List<SysUser> dataList = userService.selectUserList(model);
            PageInfo<SysUser> pageInfo = new PageInfo<>(dataList);
            response = new Response(200,null,pageInfo,model);
        }catch (Exception e){
            e.printStackTrace();
            response = new Response(500,null,null,model);
        }
        return response;
    }

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    @PostMapping("/addUser")
    @com.hx.config.Log(businessModule = "用户管理", businessType = BusinessType.INSERT)
    public Response add(SysUser sysUser)
    {
        Response response = null;
        if (Constants.NOT_UNIQUE.equals(userService.checkUserNameUnique(sysUser.getUserName())))
        {
            return response = new Response(500,"\"新增用户'\" + user.getUserName() + \"'失败，登录账号已存在\"");
        }
//        User user = (User) httpSession.getAttribute("USER_SESSION");
        User user = new User();
        sysUser.setPassword(sysUser.getPassword());
        int result =userService.insertUser(sysUser);

        if(result>0){
            response = new Response(200,"success:新增用户成功!");
        }else {
            response = new Response(500,"fail:新增用户失败!");
        }
        return response;
    }

    @PostMapping("/updateUser")
    @Log(businessModule = "用户管理", businessType = BusinessType.UPDATE)
    public Response edit(@Validated @RequestBody SysUser sysUser)
    {
        Response response = null;
        User user = (User) httpSession.getAttribute("USER_SESSION");
        sysUser.setUpdateBy(user.getUsername());
        int result =userService.updateUser(sysUser);
        if(result>0){
            response = new Response(200,"success:新增用户成功!");
        }else {
            response = new Response(500,"fail:新增用户失败!");
        }
        return response;
    }

    /**
     * 删除用户
     */
    @Log(businessModule = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping(value ="/userIds")
//    @GetMapping(value = "/getByUser")
    @ResponseBody
    public Response remove(Long userIds)
    {
        Response response = null;
        int result = userService.deleteUserById(userIds);
        if(result>0){
            response = new Response(200,"success:新增用户成功!");
        }else {
            response = new Response(500,"fail:新增用户失败!");
        }
        return response;
    }
}
