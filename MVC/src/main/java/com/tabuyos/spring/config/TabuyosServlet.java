package com.tabuyos.spring.config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @Author Tabuyos
 * @Time 3/13/20 10:28 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class TabuyosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = TabuyosServlet.class.getResource("/").getPath();
        String fileName = request.getRequestURI();
        System.out.println(basePath + fileName);
        File file = new File(this.getClass().getResource(fileName).getPath());
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[2048];
        int read = inputStream.read(bytes);
        System.out.println("Read from inputStream: " + read);
        inputStream.close();
        String string = new String(bytes);
        response.setContentType("text/html");
        response.getWriter().write(string);
    }
}
