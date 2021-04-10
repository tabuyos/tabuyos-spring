package com.tabuyos.jpa.controller;

import com.tabuyos.jpa.rep1.UserRepository1;
import com.tabuyos.jpa.rep2.UserRepository2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tabuyos
 * @Time 2020/4/16 23:03
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@RestController
public class HeController {
    private UserRepository2 userRepository2;

    public HeController(UserRepository2 userRepository2) {
        this.userRepository2 = userRepository2;
    }

    @GetMapping("/secondary")
    public void secondary() {
        System.out.println(userRepository2.getObject().toString());
    }
}
