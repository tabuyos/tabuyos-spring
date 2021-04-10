package com.tabuyos.spring.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @Author Tabuyos
 * @Time 2020/3/23 17:38
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class TabuyosImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {



        System.out.println(importingClassMetadata.getAnnotationAttributes(TabuyosScan.class.getName()));
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(TabuyosMapperFactoryBean.class);
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.tabuyos.spring.mapper.BlogMapper");
        registry.registerBeanDefinition("tabuyosMapperFactoryBean", beanDefinition);
    }
}
