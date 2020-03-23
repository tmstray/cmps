package com.hx.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.config.Constants;
import com.hx.config.Log;
import com.hx.entity.MainData;
import com.hx.entity.SysUser;
import com.hx.entity.User;
import com.hx.model.BusinessType;
import com.hx.model.MainDataModel;
import com.hx.model.Response;
import com.hx.service.SysUserService;
import com.hx.utils.ResultUtil;
import com.hx.utils.page.object.BaseConditionVO;
import com.hx.utils.page.object.PageResult;

import lombok.extern.slf4j.Slf4j;

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
    
    private Map<String, Object> result = new HashMap<>();
    
    
    @GetMapping("/goSysUserListView")
    public ModelAndView goSysUserListView(ModelAndView modelAndView) {
        //向页面发送一个存储着Clazz的List对象
        modelAndView.setViewName("user3");
        return modelAndView;
    }
    
    @PostMapping("/getUserList")
    @ResponseBody//these params seem like...why not included in basic value Object
    public PageResult getFriendList(Integer page, Integer rows) {
        //获取封装查询结果
        PageInfo<SysUser> pageInfo = userService.selectForPage(new BaseConditionVO(page, rows));
        //返回分页数据
        return ResultUtil.tablePage(pageInfo);
    }
    
    @PostMapping("/updateUser")
    @ResponseBody
    public Map<String, Object> editFriend(SysUser sysUser) {
        return userService.updateUser(sysUser) > 0 ? ResultUtil.success() : ResultUtil.error("更新失败:服务器端发生异常!");
    }
    
    @PostMapping("/getUserList22")
    @ResponseBody
    public Map<String, Object> getStudentList(Integer page, Integer rows) {

        //存储查询的studentname,clazzname信息
//        Student student = new Student(studentname, clazzname);
        //设置每页的记录数
        PageHelper.startPage(page, rows);
        //根据班级与学生名获取指定或全部学生信息列表
//        List<Student> list = studentService.selectList(student);
        List<SysUser> list = userService.selectUserList(null);
        //封装信息列表
        PageInfo<SysUser> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        //获取当前页数据列表
        List<SysUser> studentList = pageInfo.getList();
        //存储数据对象
        result.put("total", total);
        result.put("rows", studentList);

        return result;
    }
    
    @PostMapping("/addSysUser")
    @ResponseBody
    public Map<String, Object> addStudent(SysUser sysUser) {
        //判断学号是否已存在
//        if (studentService.fingBySno(student) != null) {
//            result.put("success", false);
//            result.put("msg", "该学号已经存在! 请修改后重试!");
//            return result;
//        }
        if (userService.insertUser(sysUser) > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
            result.put("msg", "添加失败! (ಥ_ಥ)服务器端发生异常!");
        }

        return result;
    }
    
    @PostMapping("/editSysUser")
    @ResponseBody
    public Map<String, Object> editStudent(SysUser sysUser) {
        if (userService.updateUser(sysUser) > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
            result.put("msg", "添加失败! (ಥ_ಥ)服务器端发生异常!");
        }
        return result;
    }
    
    @PostMapping("/deleteSysUser")
    @ResponseBody
    public Map<String, Object> deleteStudent(@RequestParam(value = "ids[]", required = true) Integer[] ids) {

//        if (studentService.deleteById(ids) > 0) {
//            result.put("success", true);
//        } else {
//            result.put("success", false);
//        }
        return result;
    }
    

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
            return new Response(500,"新增用户失败，登录账号已存在");
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

    @PostMapping("/updateUser22")
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
