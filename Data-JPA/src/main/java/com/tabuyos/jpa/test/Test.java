package com.tabuyos.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author Tabuyos
 * @Time 2020/4/16 22:28
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@SpringBootApplication(scanBasePackages = {"com.tabuyos.jpa"})
public class Test {
    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);
    }
}
