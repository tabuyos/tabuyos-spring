package com.tabuyos.spring.test;

import com.tabuyos.spring.service.UserService;
import com.tabuyos.spring.util.BeanFactory;

/**
 * @Author Tabuyos
 * @Time 3/7/20 10:39 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Test2 {

    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory("spring.xml");
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.find();
    }
}
