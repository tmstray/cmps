package com.hx.config;

import com.hx.intercepter.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: eqds-ms
 * @description:
 * @author: yangyue
 * @create: 2019/12/19 15:48
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        //registry.addViewController("/login").setViewName("datalist");
    }

    /*@Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(true);
    }*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截路径：必须登录才可以访问
        List<String> patterns = new ArrayList<>();
        patterns.add("/**");
        // 白名单：在黑名单范围内，却不需要登录就可以访问
        List<String> excludePatterns = new ArrayList<>();
        excludePatterns.add("/static/**");
        excludePatterns.add("/css/**");
        excludePatterns.add("/images/**");
        excludePatterns.add("/js/**");
        excludePatterns.add("/scripts/**");
        excludePatterns.add("/style/**");
        excludePatterns.add("/webfonts/**");
        // 注册拦截器
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(patterns).excludePathPatterns(excludePatterns);
    }

}