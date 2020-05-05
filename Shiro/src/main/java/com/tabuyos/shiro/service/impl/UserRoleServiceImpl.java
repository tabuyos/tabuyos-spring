package com.tabuyos.shiro.service.impl;

import com.tabuyos.shiro.dao.UserRoleRepository;
import com.tabuyos.shiro.entity.UserRole;
import com.tabuyos.shiro.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/5/5 20:30
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public List<String> getRolesByUserId(String userId) {
        return userRoleRepository.findUserRoleByUserId(userId);
    }
}