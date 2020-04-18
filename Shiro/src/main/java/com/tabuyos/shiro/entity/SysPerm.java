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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

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
}
