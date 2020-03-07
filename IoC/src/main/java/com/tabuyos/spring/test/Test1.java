package com.tabuyos.spring.test;

import com.tabuyos.spring.service.UserService;
import com.tabuyos.spring.util.AnnotationConfigApplicationContext;

/**
 * @Author Tabuyos
 * @Time 3/7/20 9:32 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.scan("com");
        UserService userService = (UserService) ac.getBean("userService");
        userService.find();
    }
}
