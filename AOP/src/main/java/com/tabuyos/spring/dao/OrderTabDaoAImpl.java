package com.tabuyos.spring.dao;

import org.springframework.stereotype.Component;

/**
 * @Author Tabuyos
 * @Time 3/11/20 5:26 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Component
public class OrderTabDaoAImpl implements OrderTabDao {
    @Override
    public void update(String sql) {
        System.out.println(sql);
        System.out.println("A");
    }

    @Override
    public void updateProduct(String sql) {

    }
}
