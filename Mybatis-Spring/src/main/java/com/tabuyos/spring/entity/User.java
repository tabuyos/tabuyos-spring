package com.tabuyos.spring.entity;

import java.util.Date;

/**
 * @Author Tabuyos
 * @Time 2020/3/22 17:51
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class User {
    Date date;

    @Override
    public String toString() {
        return "User{" +
                "date=" + date +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
