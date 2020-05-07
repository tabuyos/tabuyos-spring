package com.tabuyos.spring.controller;

import com.tabuyos.spring.annotation.MultiRequestBody;
import com.tabuyos.spring.entity.Dog;
import com.tabuyos.spring.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tabuyos
 * @Time 2020/5/7 16:14
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@RestController
public class CommonController {

    @PostMapping("/getUserAndDog")
    public String userAndDog(@MultiRequestBody User user, @MultiRequestBody Dog dog) {
        System.out.println(user);
        System.out.println(dog);
        return "ok";
    }
}
