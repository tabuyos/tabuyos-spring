package com.tabuyos.spring.test;

import com.tabuyos.spring.config.Appconfig;
import com.tabuyos.spring.dao.OrderTabDao;
import com.tabuyos.spring.service.OrderTabServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author Tabuyos
 * @Time 3/8/20 1:22 AM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
//        ac.getBean(OrderTabDao.class).update("sql");
        ac.getBean(OrderTabServiceImpl.class).query("A");
    }
}
