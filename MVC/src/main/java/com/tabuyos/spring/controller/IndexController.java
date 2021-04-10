package com.tabuyos.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Tabuyos
 * @Time 3/13/20 8:32 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Controller
public class IndexController {
    @GetMapping("index")
    public String index() {
        System.out.println("====================IndexController====================");
        return "index";
    }
}
