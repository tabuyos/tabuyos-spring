package com.tabuyos.shiro.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Tabuyos
 * @Time 2020/5/6 23:11
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@SpringBootApplication(scanBasePackages = {"com.tabuyos.shiro"})
public class ApplicationShiro {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationShiro.class, args);
    }
}
