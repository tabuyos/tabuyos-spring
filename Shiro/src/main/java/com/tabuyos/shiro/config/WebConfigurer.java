package com.tabuyos.shiro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author Tabuyos
 * @Time 2020/5/1 17:48
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
//@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/role/**");
    }
}
