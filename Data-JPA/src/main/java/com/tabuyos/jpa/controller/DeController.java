package com.tabuyos.jpa.controller;

import com.tabuyos.jpa.service.UserService;
import com.tabuyos.jpa.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tabuyos
 * @Time 2020/4/16 23:52
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@RestController
public class DeController {
    private UserService userService;

    public DeController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/default")
    public void secondary() {
        System.out.println(userService.getObject().toString());
    }
}
