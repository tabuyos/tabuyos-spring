package com.tabuyos.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author Tabuyos
 * @Time 3/11/20 5:18 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@ComponentScan("com.tabuyos.spring")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Appconfig {
}
