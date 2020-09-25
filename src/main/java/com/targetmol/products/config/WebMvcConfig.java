package com.targetmol.products.config;

import com.targetmol.products.filter.LoginInterceptorAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptorAction loginInterceptorAction;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginInterceptorAction).excludePathPatterns("/").addPathPatterns("/**");
    }
}
