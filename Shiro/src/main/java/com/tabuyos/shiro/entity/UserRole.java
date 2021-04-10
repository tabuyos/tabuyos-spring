package com.tabuyos.shiro.entity;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * @Author Tabuyos
 * @Time 2020/4/18 21:17
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "user_id", length = 36)
    private String userId;

    @Column(name = "role_id", length = 36)
    private String roleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
