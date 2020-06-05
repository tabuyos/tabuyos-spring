package com.tabuyos.handle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.StandardCharsets;

/**
 * @Author Tabuyos
 * @Time 2020/6/5 17:37
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Configuration
public class AutoHandleRequestConfig {

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
    }

}
