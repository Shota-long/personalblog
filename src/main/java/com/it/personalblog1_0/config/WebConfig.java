package com.it.personalblog1_0.config;

import com.it.personalblog1_0.interceptor.admininterceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author lls
 * @version 1.0
 * @date 2020/5/31 15:45
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        //注册拦截器
        registry.addInterceptor(loginInterceptor)
                //拦截配置
                .addPathPatterns("/admin/**")
                //排除配置
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/toLogin")
                .excludePathPatterns("/static/**");

    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
