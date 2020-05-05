package com.tabuyos.shiro.dao;

import com.tabuyos.shiro.entity.RolePerm;
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
public interface RolePermRepository extends JpaRepository<RolePerm, String>, JpaSpecificationExecutor<RolePerm> {

    @Query("select t from SysPerm t where t.id in (select o.permId from RolePerm o where o.roleId in (select u.roleId from UserRole u where u.userId = :userId))")
    List<String> findRolePermByUserId(@Param("userId") String userId);
}
