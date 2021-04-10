package com.tabuyos.spring.test;

/**
 * @Author Tabuyos
 * @Time 2020/3/22 1:03
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Tabuyos {
    public static void main(String[] args) {
        System.out.println(test());
    }
    public static String test() {
        try {
//            throw new Exception();
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "2";
        } finally {
//            return "3";
        }
    }
}
