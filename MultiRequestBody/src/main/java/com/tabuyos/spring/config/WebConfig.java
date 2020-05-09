package com.tabuyos.spring.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tabuyos.spring.resolver.MultiRequestBodyArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/5/7 15:13
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ObjectMapper objectMapper;

    public WebConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(multiRequestBodyArgumentResolver());
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
    }

    @Bean
    public MultiRequestBodyArgumentResolver multiRequestBodyArgumentResolver() {
        MultiRequestBodyArgumentResolver multiRequestBodyArgumentResolver = new MultiRequestBodyArgumentResolver();
        multiRequestBodyArgumentResolver.setObjectMapper(objectMapper);
        return multiRequestBodyArgumentResolver;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
    }
}
