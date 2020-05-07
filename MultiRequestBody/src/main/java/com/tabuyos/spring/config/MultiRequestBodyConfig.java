package com.tabuyos.spring.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/5/7 15:28
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Configuration
public class MultiRequestBodyConfig {

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
    }

    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON);
        list.add(MediaType.TEXT_HTML);
        list.add(MediaType.TEXT_PLAIN);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(list);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig());
        return fastJsonHttpMessageConverter;
    }

    @Bean
    public FastJsonConfig fastJsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        List<SerializerFeature> list = new ArrayList<>();
//        list.add(SerializerFeature.PrettyFormat);
//        list.add(SerializerFeature.QuoteFieldNames);
//        list.add(SerializerFeature.WriteMapNullValue);
//        list.add(SerializerFeature.WriteNullListAsEmpty);
//        list.add(SerializerFeature.WriteNullNumberAsZero);
//        list.add(SerializerFeature.WriteNullStringAsEmpty);
//        list.add(SerializerFeature.WriteNullBooleanAsFalse);
//        list.add(SerializerFeature.DisableCircularReferenceDetect);
//        SerializerFeature[] serializerFeatures = (SerializerFeature[]) list.toArray();
//        fastJsonConfig.setSerializerFeatures(serializerFeatures);
        return fastJsonConfig;
    }

}
