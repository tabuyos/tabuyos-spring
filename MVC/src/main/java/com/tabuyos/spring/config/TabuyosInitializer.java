package com.tabuyos.spring.config;

import com.tabuyos.spring.test.TestInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @Author Tabuyos
 * @Time 3/13/20 9:47 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
//@HandlesTypes(TestInitializer.class)
public class TabuyosInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("====================Tabuyos-Starting====================");
        System.out.println(c);
        ServletRegistration.Dynamic registration = ctx.addServlet("tabuyosServlet", new TabuyosServlet());
        registration.addMapping("/");
        System.out.println("====================Tabuyos-Stopping====================");
    }
}
