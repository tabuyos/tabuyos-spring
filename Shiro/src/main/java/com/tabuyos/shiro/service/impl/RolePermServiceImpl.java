package com.tabuyos.shiro.service.impl;

import com.tabuyos.shiro.dao.RolePermRepository;
import com.tabuyos.shiro.service.RolePermService;
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
public class RolePermServiceImpl implements RolePermService {

    private final RolePermRepository rolePermRepository;

    public RolePermServiceImpl(RolePermRepository rolePermRepository) {
        this.rolePermRepository = rolePermRepository;
    }

    @Override
    public List<String> getPermsByUserId(String userId) {
        return rolePermRepository.findRolePermByUserId(userId);
    }
}