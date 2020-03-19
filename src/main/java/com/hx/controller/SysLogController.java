package com.hx.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hx.entity.SysLog;
import com.hx.model.Response;
import com.hx.model.SysLogDataModel;
import com.hx.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



/**
 * 日志控制器
 *
 */
@Controller
@Slf4j
@RequestMapping("/sysLog")
public class SysLogController {
   @Autowired
    SysLogService logService;

    @GetMapping(value = "/getSysLog")
    public ModelAndView findByPage(SysLogDataModel model){
        Page<SysLog> page = PageHelper.startPage(model.getPageNum(),model.getPageSize());
        List<SysLog> dataList = logService.selectSysLogList(model);
        log.info("size:" + dataList.size());
        PageInfo<SysLog> pageInfo = new PageInfo<>(dataList);
        ModelAndView mv = new ModelAndView("log");
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("requestModel",model);
        return mv;
    }


    @ResponseBody
    @PostMapping(value = "/getDataByPage")
    public Response getDataByPage(SysLogDataModel model){
        Response response = null;
        try {
            Page<SysLog> page = PageHelper.startPage(model.getPageNum(),model.getPageSize());
            List<SysLog> dataList = logService.selectSysLogList(model);
            PageInfo<SysLog> pageInfo = new PageInfo<>(dataList);
            response = new Response(200,"查询成功",pageInfo,model);
        }catch (Exception e){
            e.printStackTrace();
            response = new Response(500,"查询异常",null,model);
        }
        return response;
    }
}

