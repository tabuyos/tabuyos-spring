package com.tabuyos.spring.config;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

/**
 * @Author Tabuyos
 * @Time 3/13/20 9:57 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class TabuyosApplication {
    public static void run() throws ServletException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9080);
        // hipnote 告诉MVC源码位置
        String sourcePath = TabuyosApplication.class.getResource("/").getPath();
        Context ctx = tomcat.addWebapp("/", new File("MVC/src/main/webapp").getAbsolutePath());
        WebResourceRoot webResourceRoot = new StandardRoot(ctx);
        webResourceRoot.addPreResources(new DirResourceSet(webResourceRoot, "/WEB-INF/classes", sourcePath, "/"));
        ctx.setResources(webResourceRoot);
        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
