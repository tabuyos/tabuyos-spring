package com.tabuyos.shiro.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Tabuyos
 * @Time 2020/5/13 22:33
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class TabuyosController {

    private final ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/tabuyos")
    public String tabuyos() throws Exception {
        Map<String, Object> map = new HashMap<>(7);
        map.put("code", 200);
        map.put("msg", "successful");
        map.put("data", "get");
        return mapper.writeValueAsString(map);
    }

    @PostMapping("/login")
    public String login() throws Exception {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("Tabuyos", "123456");
        subject.login(token);
        System.out.println(subject.getSession().getId());
        return "OK";
    }
}
