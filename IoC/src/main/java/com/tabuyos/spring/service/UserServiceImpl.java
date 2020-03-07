package com.tabuyos.spring.service;

import com.tabuyos.spring.annotation.Autobind;
import com.tabuyos.spring.annotation.Tabuyos;
import com.tabuyos.spring.dao.IndexDao;
import com.tabuyos.spring.dao.UserDao;

/**
 * @Author Tabuyos
 * @Time 3/4/20 3:05 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Tabuyos("userService")
public class UserServiceImpl implements UserService {

    @Autobind
    UserDao userDao;

    @Autobind
    IndexDao indexDao;

//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void find() {
        System.out.println("UserService");
        indexDao.query();
        userDao.query();
    }
}
