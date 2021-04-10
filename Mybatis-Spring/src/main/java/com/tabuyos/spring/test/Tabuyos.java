package com.tabuyos.spring.test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Tabuyos
 * @Time 2020/3/23 1:59
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Tabuyos {
    public Map<String, Integer> aaa() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 12);
        return map;
    }

//    public static void main(String[] args) {
//        Method[] methods = Tabuyos.class.getMethods();
//        for (Method method : methods) {
//            Type genericReturnType = method.getGenericReturnType();
//            System.out.println(genericReturnType.getTypeName());
//            ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
//            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
//        }
//    }
}
