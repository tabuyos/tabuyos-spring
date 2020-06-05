package com.tabuyos.handle.entity;

import java.util.Date;

/**
 * @Author Tabuyos
 * @Time 2020/6/3 9:29
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Aaron {

    private String username;
    private int years;
    private String sex;
    private Date birthday;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Aaron{" +
                "username='" + username + '\'' +
                ", years=" + years +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
