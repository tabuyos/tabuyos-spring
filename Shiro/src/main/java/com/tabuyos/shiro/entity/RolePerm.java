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
public class RolePerm {
    @Id
    @Column(name = "id", length = 36)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "perm_id", length = 36)
    private String permId;

    @Column(name = "role_id", length = 36)
    private String roleId;
}
