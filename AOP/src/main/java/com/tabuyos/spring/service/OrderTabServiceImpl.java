package com.tabuyos.spring.service;

import com.tabuyos.spring.dao.OrderTabDao;
import com.tabuyos.spring.dao.OrderTabDaoAImpl;
import com.tabuyos.spring.dao.OrderTabDaoBImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author Tabuyos
 * @Time 3/11/20 5:30 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Service
public class OrderTabServiceImpl implements ApplicationContextAware {

    OrderTabDao orderTabDao;
    Map<String, OrderTabDao> map;
    ApplicationContext applicationContext;

//    public OrderTabServiceImpl(OrderTabDao orderTabDao) {
//        this.orderTabDao = orderTabDao;
//    }

    public void query(String username) {
        if (username.equals("A")) {
            applicationContext.getBean(OrderTabDaoAImpl.class).update("A");
        } else if (username.equals("B")) {
            applicationContext.getBean(OrderTabDaoBImpl.class).update("B");
        }
//        orderTabDao.update(username);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
