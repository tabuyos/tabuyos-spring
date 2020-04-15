package com.tabuyos.spring.factory;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author Tabuyos
 * @Time 2020/3/22 14:02
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class DataSourceFactory {
    public static DataSource getBlogDataSource() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
//            dataSource.setUrl("jdbc:mariadb://localhost/mybatis");
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("mybatis");
            dataSource.setUserName("tabuyos");
            dataSource.setPassword("tabuyos");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
