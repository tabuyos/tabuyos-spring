package com.tabuyos.spring.config;

import com.tabuyos.spring.mapper.BlogMapper;
import com.tabuyos.spring.mybatis.TabuyosImportBeanDefinitionRegistrar;
import com.tabuyos.spring.mybatis.TabuyosScan;
import com.tabuyos.spring.mybatis.TabuyosSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @Author Tabuyos
 * @Time 2020/3/22 10:35
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@ComponentScan("com.tabuyos.spring")
//@MapperScan("com.tabuyos.spring.mapper")
@TabuyosScan
public class Appconfig {

//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        return factoryBean;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
//        dataSource.setUrl("jdbc:mariadb://localhost/mybatis?useUnicode=true&userSSL=true&characterEncoding=utf8");
//        dataSource.setUsername("tabuyos");
//        dataSource.setPassword("tabuyos");
//        return dataSource;
//    }
//
//    @Bean
//    public BlogMapper blogMapper() {
//        return TabuyosSession.getMapper(BlogMapper.class);
//    }
}
