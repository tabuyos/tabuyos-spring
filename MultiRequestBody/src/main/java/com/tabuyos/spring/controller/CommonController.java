package com.tabuyos.spring.controller;

import com.tabuyos.spring.annotation.MultiRequestBody;
import com.tabuyos.spring.entity.Dog;
import com.tabuyos.spring.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

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
    public Object userAndDog(@RequestBody List<String> list) {
//        System.out.println(user);
//        System.out.println(dog);
//        System.out.println(tab);
        System.out.println(Arrays.toString(list.toArray()));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp;
    }
}
