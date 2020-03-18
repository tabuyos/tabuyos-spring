package com.tabuyos.spring.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @Author Tabuyos
 * @Time 3/13/20 7:59 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class MyWebApplicationInitializer {
//    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("====================Tabuyos-Starting====================");
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(Appconfig.class);
        annotationConfigWebApplicationContext.refresh();
        DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigWebApplicationContext);
        ServletRegistration.Dynamic registration = servletContext.addServlet("tabuyosServlet", dispatcherServlet);
        registration.addMapping("/");
        registration.setLoadOnStartup(1);
        System.out.println("====================Tabuyos-Stopping====================");
    }
}
