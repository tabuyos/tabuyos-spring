package com.tabuyos.spring.test;

import com.tabuyos.spring.config.Appconfig;
import com.tabuyos.spring.factory.TempFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author Tabuyos
 * @Time 3/4/20 2:59 PM
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Test {

    public static void main(String[] args) {
//        BeanFactory beanFactory = new BeanFactory("com.tabuyos.spring.xml");
//        UserService userService = (UserService) beanFactory.getBean("userService");
//        userService.find();

//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("xxx");
//        beanFactory.getBean("userDao");

//        BeanFactory beanFactory = new AnnotationConfigApplicationContext(Appconfig.class);

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);

//        TempFactoryBean tempFactoryBean = (TempFactoryBean) ac.getBean("daoFactoryBean");
//        tempFactoryBean.test();

//        DaoFactoryBean daoFactoryBean = (DaoFactoryBean) ac.getBean("daoFactoryBean");
//        daoFactoryBean.test();

//        DaoFactoryBean daoFactoryBean = (DaoFactoryBean) ac.getBean("&daoFactoryBean");
//        daoFactoryBean.test();

//        IndexDao indexDao = ac.getBean(IndexDao.class);
//        indexDao.query();

        TempFactoryBean tempFactoryBean = (TempFactoryBean) ac.getBean("daoFactoryBean");
        System.out.println(tempFactoryBean.getMsg1());
        System.out.println(tempFactoryBean.getMsg2());
        System.out.println(tempFactoryBean.getMsg3());

    }
}
