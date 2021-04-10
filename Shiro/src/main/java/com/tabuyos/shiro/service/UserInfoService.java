package com.tabuyos.shiro.service;

import com.tabuyos.shiro.entity.UserInfo;

import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/5/5 20:30
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public interface UserInfoService {
    List<UserInfo> selectAlla(int pageNum, int pageSize);
    UserInfo selectBy(String userName);
}
