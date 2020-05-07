package com.tabuyos.spring.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Tabuyos
 * @Time 2020/5/7 15:29
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@SpringBootApplication(scanBasePackages = {"com.tabuyos.spring"})
public class ApplicationMultiRequestBody {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMultiRequestBody.class, args);
    }
}
