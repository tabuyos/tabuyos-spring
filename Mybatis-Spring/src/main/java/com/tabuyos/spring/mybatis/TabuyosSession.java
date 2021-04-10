package com.tabuyos.spring.mybatis;

import java.lang.reflect.Proxy;

/**
 * @Author Tabuyos
 * @Time 2020/3/22 17:59
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class TabuyosSession {

    @SuppressWarnings("unchecked")
    public static <T> T getMapper(Class<?> clazz) {
        Class<?>[] classes = new Class[]{clazz};
        Object object = Proxy.newProxyInstance(TabuyosSession.class.getClassLoader(), classes, new TabuyosInvocationHandler());
        return (T) object;
    }
}
