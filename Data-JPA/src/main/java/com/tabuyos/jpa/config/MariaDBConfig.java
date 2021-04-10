package com.tabuyos.jpa.config;

import org.hibernate.dialect.MySQL8Dialect;

/**
 * @Author Tabuyos
 * @Time 2020/4/16 11:50
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class MariaDBConfig extends MySQL8Dialect {

    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4";
    }
}
