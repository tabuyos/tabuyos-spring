package com.tabuyos.spring.mybatis;

import com.tabuyos.spring.entity.Blog;
import com.tabuyos.spring.factory.DataSourceFactory;
import org.apache.ibatis.annotations.Select;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.*;

/**
 * @Author Tabuyos
 * @Time 2020/3/22 18:03
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class TabuyosInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 1. get sql
        // 2. parse sql
        // 3. execute sql
        System.out.println(method.getName());
        Select annotation = method.getAnnotation(Select.class);

        Type returnType = method.getGenericReturnType();

        String sql = annotation.value()[0];
        System.out.println("====================Tabuyos-Before====================");
        System.out.println(sql);
//        DataSource dataSource = DataSourceFactory.getBlogDataSource();
//        ResultSetHandler resultSetHandler = new DefaultResultSetHandler();
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        List<Object> list = new ArrayList<>();
//        try {
//            connection = dataSource.getConnection();
//            preparedStatement = connection.prepareStatement(sql);
//            resultSet = preparedStatement.executeQuery();
//            ResultSetMetaData metaData = resultSet.getMetaData();
//
//            while (resultSet.next()) {
//                Map<String, ?> map = new HashMap<>();
//                for (int i = 0; i < metaData.getColumnCount(); i++) {
//                    map.put(metaData.getColumnName(i + 1), Convert.convert(resultSet.getObject(i + 1)));
//                }
//                list.add(map);
//            }
////            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            assert connection != null;
//            connection.close();
//            assert preparedStatement != null;
//            preparedStatement.close();
//            assert resultSet != null;
//            resultSet.close();
//        }
        System.out.println("====================Tabuyos-After====================");
        return null;
    }
}
