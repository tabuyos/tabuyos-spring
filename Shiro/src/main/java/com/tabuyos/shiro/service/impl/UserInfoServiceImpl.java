package com.tabuyos.shiro.service.impl;

import com.tabuyos.shiro.dao.UserInfoRepository;
import com.tabuyos.shiro.entity.UserInfo;
import com.tabuyos.shiro.service.UserInfoService;
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
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public List<UserInfo> selectAlla(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public UserInfo selectBy(String userName) {
        return userInfoRepository.findUserInfoByUsername(userName);
    }
}
