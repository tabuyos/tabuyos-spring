package com.tabuyos.shiro.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author Tabuyos
 * @Time 2020/4/18 17:05
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Configuration
@EnableJpaRepositories(basePackages = { "com.tabuyos.shiro.dao" })
@EntityScan(basePackages = { "com.tabuyos.shiro.entity" })
public class ShiroConfig {
}
