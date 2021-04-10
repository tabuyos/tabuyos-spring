package com.tabuyos.shiro.dao;

import com.tabuyos.shiro.entity.UserInfo;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/4/19 11:46
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String>, JpaSpecificationExecutor<UserInfo> {

    @Query(value = "select * from user_info", nativeQuery =true)
    List<UserInfo> findAll();

//    @Query("select o from UserInfo o where o.username = :username")
    UserInfo findUserInfoByUsername(String username);
}
