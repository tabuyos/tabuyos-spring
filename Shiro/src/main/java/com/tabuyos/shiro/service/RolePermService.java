package com.tabuyos.shiro.service;

import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/5/5 20:30
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public interface RolePermService {

    List<String> getPermsByUserId(String userId);
}
