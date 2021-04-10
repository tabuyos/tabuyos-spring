package com.tabuyos.spring.mybatis;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author Tabuyos
 * @Time 2020/3/23 18:02
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(TabuyosImportBeanDefinitionRegistrar.class)
public @interface TabuyosScan {
}
