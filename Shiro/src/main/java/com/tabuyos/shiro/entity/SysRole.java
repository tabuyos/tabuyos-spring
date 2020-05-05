package com.tabuyos.shiro.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @Author Tabuyos
 * @Time 2020/4/18 21:17
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Entity
@Table(name = "sys_role")
public class SysRole {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_desc")
    private String roleDesc;

    @Column(name = "role_value")
    private String roleValue;

    @Column(name = "create_time", columnDefinition = "datetime")
    private Timestamp createTime;

    @Column(name = "update_time", columnDefinition = "datetime")
    private Timestamp updateTime;

    @Column(name = "is_disable", length = 1)
    private Integer isDisable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", roleValue='" + roleValue + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDisable=" + isDisable +
                '}';
    }
}
