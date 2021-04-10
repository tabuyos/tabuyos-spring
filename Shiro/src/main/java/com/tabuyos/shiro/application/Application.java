package com.tabuyos.shiro.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author Tabuyos
 * @Time 2020/4/18 17:03
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@EnableFeignClients(basePackages = {"com.tabuyos.shiro.service"})
@SpringBootApplication(scanBasePackages = {"com.tabuyos.shiro"})
@EnableJpaRepositories(basePackages = { "com.tabuyos.shiro.dao" })
@EntityScan(basePackages = { "com.tabuyos.shiro.entity" })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
