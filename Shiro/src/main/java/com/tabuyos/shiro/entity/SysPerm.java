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
@Table(name = "sys_perm")
public class SysPerm {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "perm_name")
    private String permName;

    @Column(name = "perm_desc")
    private String permDesc;

    @Column(name = "perm_value")
    private String permValue;

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

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getPermDesc() {
        return permDesc;
    }

    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc;
    }

    public String getPermValue() {
        return permValue;
    }

    public void setPermValue(String permValue) {
        this.permValue = permValue;
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
        return "SysPerm{" +
                "id='" + id + '\'' +
                ", permName='" + permName + '\'' +
                ", permDesc='" + permDesc + '\'' +
                ", permValue='" + permValue + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDisable=" + isDisable +
                '}';
    }
}
