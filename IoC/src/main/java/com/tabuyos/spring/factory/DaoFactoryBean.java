package com.tabuyos.spring.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author Tabuyos
 * @Time 3/6/20 5:09 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class DaoFactoryBean implements FactoryBean {

    private String msg = "";

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void test() {
        System.out.println("DaoFactoryBean test.");
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Object getObject() throws Exception {
        TempFactoryBean tempFactoryBean = new TempFactoryBean();
        String[] msgArray = msg.split(",");
        tempFactoryBean.setMsg1(msgArray[0]);
        tempFactoryBean.setMsg2(msgArray[1]);
        tempFactoryBean.setMsg3(msgArray[2]);
        return tempFactoryBean;
    }

    @Override
    public Class<?> getObjectType() {
        return DaoFactoryBean.class;
    }
}
