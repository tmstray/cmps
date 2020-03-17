package com.hx.controller;

import com.hx.config.Log;
import com.hx.config.LoginConfig;
import com.hx.entity.User;
//import com.hx.service.MainDataService;
import com.hx.model.BusinessType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @program: eqds-ms
 * @description:
 * @author: yangyue
 * @create: 2019/12/19 15:05
 */
@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LoginConfig loginConfig;

    @Autowired
 //   MainDataService mainDataService;

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    @Log(businessModule = "用户登录", businessType = BusinessType.LOGIN)
    public String login(HttpSession session, User user) {
        logger.debug(user.toString());
        if (user.getUsername().equals(loginConfig.getUsername()) &&
                user.getPassword().equals(loginConfig.getPassword())) {
            //将用户对象添加到Session中
            user.setSimpled(loginConfig.isSimpled());
            /*logger.info("登录成功,开始同步数据... and simpled:" + user.isSimpled());
            mainDataService.dataSynchronize(user.isSimpled());
            logger.info("登录同步数据完成...");*/
            session.setAttribute("USER_SESSION", user);
            //重定向到主页面的跳转方法
            return "redirect:/eqds/getByPage";
//            return "redirect:/cement/getByPage";
        }
        return "login";
    }

    @RequestMapping(value = "/logout")
    @Log(businessModule = "退出登录", businessType = BusinessType.LOGOUT)
    public String logout(HttpSession session) {
        //清除session
        session.invalidate();
        //重定向到登录页面的跳转方法
        return "redirect:login";
    }

}
