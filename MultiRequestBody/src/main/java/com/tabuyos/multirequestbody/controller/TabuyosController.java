package com.tabuyos.multirequestbody.controller;

import com.tabuyos.multirequestbody.annotation.MultiRequestBody;
import com.tabuyos.multirequestbody.entity.Aaron;
import com.tabuyos.multirequestbody.entity.Tabuyos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author Tabuyos
 * @Time 2020/5/12 9:37
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@RestController
public class TabuyosController {

    /**
     * 能接受 form urlencoded
     *
     * @param string string
     */
    @PostMapping("/tabuyos")
    public void tabuyosPost(String string, HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            System.out.println(key + "->" + request.getHeader(key));
        }
        delimiter(20);
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String key = attributeNames.nextElement();
            System.out.println(key + "->" + request.getAttribute(key));
        }
        delimiter(20);
        System.out.println("Post");
        System.out.println(string);
        delimiter(20);
    }

    /**
     * 能接受 form
     *
     * @param string string
     */
    @GetMapping("/tabuyos")
    public void tabuyosGet(String string) {
        delimiter(20);
        System.out.println("Get");
        System.out.println(string);
        delimiter(20);
    }

    public void delimiter(int count) {
        delimiter(count, "=");
    }

    public void delimiter(int count, String delimiter) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(delimiter);
        }
        System.out.println(builder.toString());
    }

    @GetMapping("/index")
    public Tabuyos index(@MultiRequestBody Tabuyos tabuyos, @MultiRequestBody Aaron aaron, @MultiRequestBody int age,
                         @MultiRequestBody int nian) {
        System.out.println(tabuyos);
        System.out.println(aaron);
        System.out.println(nian);
        System.out.println(age);
        return tabuyos;
    }
}
