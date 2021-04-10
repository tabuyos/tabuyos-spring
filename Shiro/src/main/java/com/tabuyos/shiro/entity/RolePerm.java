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
@Table(name = "role_perm")
public class RolePerm {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "perm_id", length = 36)
    private String permId;

    @Column(name = "role_id", length = 36)
    private String roleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "RolePerm{" +
                "id='" + id + '\'' +
                ", permId='" + permId + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
