package com.hx.config;


import com.hx.model.BusinessType;

import java.lang.annotation.*;

/**
 *
 * @Description: 自定义操作日志记录注解
 * @author Administrator
 * @date: 2019年12月26日下午2:10:34
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log
{
    /**
     * 模块
     */
    public String businessModule() default "";
    /**
     * 功能
     */
    public BusinessType businessType() default BusinessType.OTHER;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;
}

