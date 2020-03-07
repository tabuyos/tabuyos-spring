package com.tabuyos.spring.dao;

import com.tabuyos.spring.annotation.Tabuyos;
import org.springframework.stereotype.Component;

/**
 * @Author Tabuyos
 * @Time 3/4/20 3:03 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Component("indexDao")
@Tabuyos("indexDao")
public class IndexDaoImpl implements IndexDao{

    @Override
    public void query() {
        System.out.println("IndexDao");
    }
}
