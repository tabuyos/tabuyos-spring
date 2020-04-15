package com.tabuyos.spring.mybatis;

import com.tabuyos.spring.mapper.BlogMapper;
import com.tabuyos.spring.service.UserService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Author Tabuyos
 * @Time 2020/3/23 16:56
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class TabuyosMapperFactoryBean implements FactoryBean<Object> {
    Class<?> mapperInterface;

    public TabuyosMapperFactoryBean(Class<?> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object getObject() throws Exception {
        return TabuyosSession.getMapper(mapperInterface);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}
