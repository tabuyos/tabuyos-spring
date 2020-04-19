package com.tabuyos.jpa.service.impl;

import com.tabuyos.jpa.entity.User;
import com.tabuyos.jpa.dao.UserRepository;
import com.tabuyos.jpa.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/4/19 12:06
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> getObject() {
        return userRepository.getObject();
    }
}
