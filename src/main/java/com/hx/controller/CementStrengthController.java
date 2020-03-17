package com.hx.controller;

import com.github.pagehelper.PageInfo;
import com.hx.entity.CementStrength;
import com.hx.entity.User;
import com.hx.model.MainDataModel;
import com.hx.model.Response;
import com.hx.service.CementStrengthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.awt.image.RescaleOp;

@Controller
@RequestMapping(value = "/cement")
public class CementStrengthController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    CementStrengthService cementStrengthService;
    @GetMapping(value = "/getByPage")
    public ModelAndView findByPage(MainDataModel model){
        //pageNum 当前页 pageSize 每页的数量 size 当前页的数量
        Integer pageNum1 = model.getPageNum();
        int pageNum=(pageNum1==null)?1:pageNum1;
        Integer pageSize1 = model.getPageSize();
        int pageSize=(pageSize1==null)?10:pageSize1;
        Integer status = model.getStatus();
        String sampleNo = model.getCondition();
        PageInfo<CementStrength> pageInfo = cementStrengthService.findByPage(pageNum, pageSize,status,sampleNo);
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("requestModel",model);
        return mv;
    }
/*    public ModelAndView findByPage(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum ){
        Integer pageSize=18;//pageNum 当前页 pageSize 每页的数量 size 当前页的数量
        PageInfo<CementStrength> pageInfo = cementStrengthService.findByPage(pageNum, pageSize);
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }*/
    @PostMapping(value = "/getDataByPage")
    @ResponseBody
    public Response getDataByPage(MainDataModel model) {
        logger.debug("数据查询：");
        Response response = null;
        try {
            Integer pageNum = model.getPageNum();
            Integer pageSize = model.getPageSize();
            Integer status = model.getStatus();
            String sampleNo = model.getCondition();
            PageInfo<CementStrength> pageInfo = cementStrengthService.findByPage(pageNum, pageSize,status,sampleNo);
            response = new Response(200,null,pageInfo,model);
        }catch (Exception e){
            e.printStackTrace();
            response = new Response(500,null,null,null);
        }
        return response;
    }
    @ResponseBody
    @PostMapping(value = "/synchronize")
    public Response dataSynchronize(HttpSession session) {
        logger.info("同步数据开始.....");
        User user = (User) session.getAttribute("USER_SESSION");
        boolean result = cementStrengthService.dataSynchronize();
        logger.info("同步数据结束......");
        Response response = null;
        if(result){
            response = new Response(200,"success");
        }else {
            response = new Response(500,"fail");
        }
        return response;

    }

    @PostMapping(value = "/upload")
    @ResponseBody
    public Response calculateAndCreateFile(HttpSession session, String[] ids){
        logger.info("开始上传数据生成文件...");
        logger.debug("param ids.size():" + ids.length);
        User user = (User)session.getAttribute("USER_SESSION");
        boolean result = cementStrengthService.createFile(ids);
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