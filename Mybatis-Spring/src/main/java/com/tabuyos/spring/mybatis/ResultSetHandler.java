package com.tabuyos.spring.mybatis;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/3/23 13:33
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public interface ResultSetHandler {

    <T> T handleResultSets(List<T> list, Type type) throws Throwable;
}
