package com.tabuyos.shiro.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Tabuyos
 * @Time 2020/5/5 15:00
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@FeignClient(url = "${feign.url}", name = "engine")
public interface FeignClientService {
    @GetMapping("/user/getLogin")
    String getFailed();

    @PostMapping("/user/postLogin")
    String getSuccessful(@RequestParam("token") String token);
}
