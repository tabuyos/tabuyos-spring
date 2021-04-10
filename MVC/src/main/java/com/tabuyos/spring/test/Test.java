package com.tabuyos.spring.test;

import com.tabuyos.spring.config.TabuyosApplication;

import javax.servlet.ServletException;

/**
 * @Author Tabuyos
 * @Time 3/13/20 10:40 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        try {
            TabuyosApplication.run();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
