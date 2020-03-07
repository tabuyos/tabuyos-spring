package com.tabuyos.spring.dao;

import com.tabuyos.spring.annotation.Tabuyos;

/**
 * @Author Tabuyos
 * @Time 3/4/20 3:03 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Tabuyos("userDao")
public class UserDaoImpl implements UserDao{

    @Override
    public void query() {
        System.out.println("UserDao");
    }
}
