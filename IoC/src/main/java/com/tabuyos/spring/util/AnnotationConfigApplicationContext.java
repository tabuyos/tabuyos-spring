package com.tabuyos.spring.util;

import com.tabuyos.spring.annotation.Autobind;
import com.tabuyos.spring.annotation.Tabuyos;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author Tabuyos
 * @Time 3/7/20 9:21 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class AnnotationConfigApplicationContext {

    private Map<String, Object> map = new HashMap<>();
    private Map<Map<Field, Object>, String> tempMap = new HashMap<>();

    public void scan(String basePackage) {
        String rootPath = this.getClass().getResource("/").getPath();
        String basePackagePath = basePackage.replace(".", File.separator);
        File file = new File(rootPath + File.separator + basePackagePath);
        String[] names = file.list();
        Object object;
        for (String name : Objects.requireNonNull(names)) {
            name = name.replace(".class", "");
            File f = new File(rootPath + File.separator + basePackagePath + File.separator + name);
            if (f.isDirectory()) {
                scan(basePackage + "." + name);
                continue;
            }
            try {
                Class<?> clazz = Class.forName(basePackage + "." + name);
                if (clazz.isAnnotationPresent(Tabuyos.class)) {
                    Tabuyos tabuyos = clazz.getAnnotation(Tabuyos.class);
                    object = clazz.getConstructor().newInstance();
                    map.put(tabuyos.value(), object);

                    Field[] fields = clazz.getDeclaredFields();
                    for (Field field : fields) {
                        if (field.getAnnotation(Autobind.class) != null) {
                            Class<?> injectObjectClass = field.getType();
                            String key = field.getName();
                            Object injectObject = null;
                            if (map.get(key) != null) {
                                Class<?> temp = map.get(field.getName()).getClass().getInterfaces()[0];
                                if (temp.getName().equals(injectObjectClass.getName())) {
                                    injectObject = map.get(key);
                                }
                                field.setAccessible(true);
                                field.set(object, injectObject);
                            } else {
                                Map<Field, Object> t = new HashMap<>();
                                t.put(field, object);
                                tempMap.put(t, key);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!tempMap.isEmpty()) {
            try {
                for (Map<Field, Object> fieldObjectMap : tempMap.keySet()) {
                    String key = tempMap.get(fieldObjectMap);
                    Object injectObject = map.get(key);
                    for (Field field : fieldObjectMap.keySet()) {
                        Object o = fieldObjectMap.get(field);
                        field.setAccessible(true);
                        field.set(o, injectObject);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object getBean(String beanName) {
        return map.get(beanName);
    }
}
