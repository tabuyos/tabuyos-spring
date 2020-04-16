package com.tabuyos.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author Tabuyos
 * @Time 2020/4/16 22:30
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Entity
public class User {
    @Id
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
