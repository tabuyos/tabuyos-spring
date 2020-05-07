package com.tabuyos.spring.entity;

/**
 * @Author Tabuyos
 * @Time 2020/5/7 16:16
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class User {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
