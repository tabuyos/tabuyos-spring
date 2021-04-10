package com.tabuyos.cas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Tabuyos
 * @Time 2020/5/1 18:22
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hi")
    public String hi() {
        return "Hi Aaron Liew";
    }

    @PostMapping("/postLogin")
    public String postLogin(String token) {
        System.out.println(token);
        return token;
    }

    @GetMapping("/getLogin")
    public String getLogin() {
        Map<String, String> map = new HashMap<>();
        map.put("code", "400");
        map.put("data", "tabuyos");
        map.put("msg", "failed");
        return map.toString();
    }
}
