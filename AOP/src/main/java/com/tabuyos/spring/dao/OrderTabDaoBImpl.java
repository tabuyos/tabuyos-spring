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
public class OrderTabDaoBImpl implements OrderTabDao {
    @Override
    public void update(String sql) {
        System.out.println(sql);
        System.out.println("B");
    }

    @Override
    public String updateProduct(String sql) {
        return null;
    }
}
