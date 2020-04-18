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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

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

    @Column(name = "is_disable")
    private Integer isDisable;
}
