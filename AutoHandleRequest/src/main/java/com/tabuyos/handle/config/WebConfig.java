package com.tabuyos.handle.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tabuyos.handle.resovler.AutoHandleArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/6/3 15:36
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ObjectMapper objectMapper;

    public WebConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(autoHandleArgumentResolver(objectMapper));
    }

    private AutoHandleArgumentResolver autoHandleArgumentResolver(ObjectMapper objectMapper) {
        AutoHandleArgumentResolver resolver = new AutoHandleArgumentResolver();
        resolver.setObjectMapper(objectMapper);
        return resolver;
    }
}
