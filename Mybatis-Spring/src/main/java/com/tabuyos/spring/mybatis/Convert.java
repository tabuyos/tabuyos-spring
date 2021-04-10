package com.tabuyos.spring.mybatis;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author Tabuyos
 * @Time 2020/3/23 0:43
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Convert {
    @SuppressWarnings("unchecked")
    public static <T> T convert(Object object) {
        return (T) object;
    }

    @SuppressWarnings("unchecked")
    public static <T> T convertToEntity(Map<String, Object> map, Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Constructor<?> constructor;
        Object object = null;
        try {
            constructor = clazz.getConstructor();
            object = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        if (fields.length != map.keySet().size()) {
//            System.out.println("Map doesn't match Entity.");
//        }
        for (Field field : fields) {
            if (map.containsKey(field.getName())) {
                try {
                    field.setAccessible(true);
                    field.set(object, map.get(field.getName()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return (T) object;
    }
}
