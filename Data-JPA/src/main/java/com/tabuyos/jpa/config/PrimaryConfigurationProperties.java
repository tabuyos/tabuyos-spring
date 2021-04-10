package com.tabuyos.jpa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Author Tabuyos
 * @Time 2020/4/17 19:13
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description Primary数据源的元数据配置
 */
@ConfigurationProperties(prefix = "spring.datasource.primary")
public class PrimaryConfigurationProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private String schema;
    private String initializationMode;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getInitializationMode() {
        return initializationMode;
    }

    public void setInitializationMode(String initializationMode) {
        this.initializationMode = initializationMode;
    }

    @Override
    public String toString() {
        return "MyConfigurationProperties{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                ", schema='" + schema + '\'' +
                ", initializationMode='" + initializationMode + '\'' +
                '}';
    }
}
