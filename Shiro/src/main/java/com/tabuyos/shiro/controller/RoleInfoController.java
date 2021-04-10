package com.tabuyos.shiro.controller;

import com.tabuyos.shiro.service.FeignClientService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Tabuyos
 * @Time 2020/5/1 17:52
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@RestController
@RequestMapping("/role")
public class RoleInfoController {

    private final FeignClientService feignClientService;

    public RoleInfoController(FeignClientService feignClientService) {
        this.feignClientService = feignClientService;
    }

    @GetMapping("/hi")
    public String sayHi() {
        String failed = feignClientService.getFailed();
        String successful = feignClientService.getSuccessful("fdsjklfjdskfjfkdlsfdsjfklds");
        System.out.println(failed);
        System.out.println(successful);
        return "Hi Tabuyos";
    }
}
