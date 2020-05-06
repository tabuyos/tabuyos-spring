package com.tabuyos.shiro.service;


import com.tabuyos.shiro.entity.UserInfo;
import com.tabuyos.shiro.entity.UserVO;

/**
 * service接口：
 *
 * @author zxj
 * @date 2018-10-24 23:39:38
 * 版权所有：@撸码识途 版权所有(C) 2018
 */
public interface UserService {

    UserVO login(String username, String password);

    UserInfo findByUsername(String userName);
}
