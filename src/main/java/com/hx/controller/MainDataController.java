package com.hx.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.hx.config.Log;
import com.hx.entity.MainData;
import com.hx.entity.User;
import com.hx.model.BusinessType;
import com.hx.model.MainDataModel;
import com.hx.model.Response;
import com.hx.service.MainDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: eqds-ms
 * @description:
 * @author: yangyue
 * @create: 2019/12/19 11:30
 */
@Controller
@RequestMapping(value = "/eqds")
public class MainDataController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MainDataService mainDataService;


    @GetMapping(value = "/getByPage")
    public ModelAndView findByPage(MainDataModel model){

        /*Integer pageNum = model.getPageNum();
        Integer pageSize = model.getPageSize();

        Page<MainData> page = PageHelper.startPage(pageNum == null?1:pageNum,
                pageSize == null?10:pageSize);*/

        Page<MainData> page = PageHelper.startPage(model.getPageNum(),model.getPageSize());
        List<MainData> dataList = mainDataService.findByPage(model);

        logger.debug("size:" + dataList.size());

        PageInfo<MainData> pageInfo = new PageInfo<>(dataList);
        ModelAndView mv = new ModelAndView("eqds_list");
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("requestModel",model);
        return mv;
    }

    @PostMapping(value = "/getDataByPage")
    @ResponseBody
    public Response getDataByPage(MainDataModel model){
        logger.debug("数据查询:"+ model.toString());
        Response response = null;
        try {
            /*Integer pageNum = model.getPageNum();
            Integer pageSize = model.getPageSize();

            Page<MainData> page = PageHelper.startPage(pageNum == null?1:pageNum,
                    pageSize == null?10:pageSize);*/

            Page<MainData> page = PageHelper.startPage(model.getPageNum(),model.getPageSize());
            List<MainData> dataList = mainDataService.findByPage(model);

            logger.debug("size:" + dataList.size());

            PageInfo<MainData> pageInfo = new PageInfo<>(dataList);
            response = new Response(200,null,pageInfo,model);
        }catch (Exception e){
            e.printStackTrace();
            response = new Response(500,null,null,null);
        }
        return response;
    }

    @ResponseBody
    @PostMapping(value = "/synchronize")
    @Log(businessModule = "煤炭热值", businessType = BusinessType.SYNCHRONIZE)
    public Response dataSynchronize(HttpSession session){
        logger.info("同步数据开始...");
        User user = (User)session.getAttribute("USER_SESSION");
        logger.info("simpled:" + user.isSimpled());
        boolean result = mainDataService.dataSynchronize(user.isSimpled());
        logger.info("同步数据结束...");
        Response response = null;
        if(result){
            response = new Response(200,"success");
        }else {
            response = new Response(500,"fail");
        }
        return response;
    }


    @ResponseBody
    @PostMapping(value = "/upload")
    @Log(businessModule = "煤炭热值", businessType = BusinessType.UPLOAD)
    public Response calculateAndCreateFile(HttpSession session, String[] ids){
        logger.info("开始上传数据生成文件...");
        logger.debug("param ids.size():" + ids.length);
        User user = (User)session.getAttribute("USER_SESSION");
        logger.info("simpled:" + user.isSimpled());
        boolean result = mainDataService.createFile(ids, user.isSimpled());
        logger.info("数据上传完成...");
        Response response = null;
        if(result){
            response = new Response(200,"success");
        }else {
            response = new Response(500,"fail");
        }
        return response;
    }
}
