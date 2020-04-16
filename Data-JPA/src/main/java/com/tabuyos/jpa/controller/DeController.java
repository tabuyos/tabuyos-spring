package com.tabuyos.jpa.controller;

import com.tabuyos.jpa.rep.UserRepository;
import com.tabuyos.jpa.rep2.UserRepository2;
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
    private UserRepository userRepository;

    public DeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/default")
    public void secondary() {
        System.out.println(userRepository.getObject().toString());
    }
}
