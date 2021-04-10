package com.tabuyos.jpa.test;

import com.tabuyos.jpa.config.PrimaryConfigurationProperties;
import com.tabuyos.jpa.config.SecondaryConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Author Tabuyos
 * @Time 2020/4/16 22:28
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@SpringBootApplication(scanBasePackages = {"com.tabuyos.jpa"})
//@ConfigurationPropertiesScan({ "com.tabuyos.jpa.config" })
@EnableConfigurationProperties({PrimaryConfigurationProperties.class, SecondaryConfigurationProperties.class})
public class Test {
    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);
    }
}
