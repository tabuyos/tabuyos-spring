package com.tabuyos.jpa.controller;

import com.tabuyos.jpa.rep1.UserRepository1;
import com.tabuyos.jpa.rep2.UserRepository2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tabuyos
 * @Time 2020/4/16 22:42
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@RestController
public class HiController {
    private UserRepository1 userRepository1;

    public HiController(UserRepository1 userRepository1) {
        this.userRepository1 = userRepository1;
    }

    @GetMapping("/primary")
    public void primary() {
        System.out.println(userRepository1.getObject().toString());
    }
}
