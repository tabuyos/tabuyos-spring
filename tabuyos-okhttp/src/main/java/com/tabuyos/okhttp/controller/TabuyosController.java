package com.tabuyos.okhttp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Tabuyos
 * @Time 2020/7/10 13:38
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@RestController
public class TabuyosController {

    @RequestMapping(path = "tabuyos", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> tabuyos() {
        Map<String, Object> map = new HashMap<>(7);
        map.put("state", 200);
        map.put("msg", "successful");
        return map;
    }
}
