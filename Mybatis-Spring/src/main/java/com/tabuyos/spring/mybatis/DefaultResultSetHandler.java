package com.tabuyos.spring.mybatis;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.*;

/**
 * @Author Tabuyos
 * @Time 2020/3/23 13:39
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class DefaultResultSetHandler implements ResultSetHandler {
    @SuppressWarnings("unchecked")
    @Override
    public <T> T handleResultSets(List<T> list, Type type) throws Throwable {

        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            Type[] genericArguments = parameterizedType.getActualTypeArguments();
            if (rawType.getTypeName().equals(Map.class.getName()) || rawType.getClass().getDeclaredConstructor().newInstance() instanceof Map) {
                Class<?> argument1 = (Class<?>) genericArguments[0];
                Class<?> argument2 = (Class<?>) genericArguments[0];
                if (list.size() == 0) {
                    System.out.println("ResultSet is empty.");
                    return null;
                } else if (list.size() == 1) {
                    Map<?, ?> map = new HashMap<>();
                    
                    return list.get(0);
                } else {
                    System.out.println("Error type.");
                }
            } /*else if (rawType.getTypeName().equals(List.class.getName()) || rawType.getClass().getDeclaredConstructor().newInstance() instanceof List) {
                genericArguments[0]
                if (list.size() == 0) {
                    System.out.println("ResultSet is empty.");
                    return null;
                } else if (list.size() == 1) {
                    return list.get(0);
                } else {
                    System.out.println("Error type.");
                }
            } else if (rawType.getTypeName().equals(Set.class.getName()) || rawType.getClass().getDeclaredConstructor().newInstance() instanceof Set) {
                genericArguments[0]
                if (list.size() == 0) {
                    System.out.println("ResultSet is empty.");
                    return null;
                } else if (list.size() == 1) {
                    return list.get(0);
                } else {
                    System.out.println("Error type.");
                }
            }*/

            System.out.println("====================Tabuyos-Separator====================");


            System.out.println(type);
            System.out.println(parameterizedType.toString());
            System.out.println("------------------------------------------");
            System.out.println(rawType);
            System.out.println("------------------------------------------");
            System.out.println(genericArguments[0]);
        } else {
            return null;
        }

        if (list.size() == 0) {
            return null;
        }
        return null;
    }
}
