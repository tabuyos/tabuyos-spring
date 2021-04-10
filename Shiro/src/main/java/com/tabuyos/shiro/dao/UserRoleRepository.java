package com.tabuyos.shiro.dao;

import com.tabuyos.shiro.entity.UserInfo;
import com.tabuyos.shiro.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/5/5 20:56
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String>, JpaSpecificationExecutor<UserRole> {

    @Query("select o.roleValue from SysRole o where o.id in (select u.roleId from UserRole u where u.userId = :userId)")
    List<String> findUserRoleByUserId(@Param("userId") String userId);
}
