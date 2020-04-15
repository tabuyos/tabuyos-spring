package com.tabuyos.spring.test;

import com.tabuyos.spring.config.Appconfig;
import com.tabuyos.spring.entity.Blog;
import com.tabuyos.spring.entity.User;
import com.tabuyos.spring.mapper.BlogMapper;
import com.tabuyos.spring.mybatis.TabuyosMapperFactoryBean;
import com.tabuyos.spring.mybatis.TabuyosSession;
import com.tabuyos.spring.service.BlogService;
import com.tabuyos.spring.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author Tabuyos
 * @Time 2020/3/22 10:34
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Test {
    /*
      1. 设置数据源
      2. 提供Mapper
      3. 注入Mapper
      原理: JDK动态代理产生Mapper对象
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
//        System.out.println(ac.getBean(TabuyosMapperFactoryBean.class));
        ac.getBean(BlogService.class).queryAll();
//        System.out.println(ac.getBean(UserService.class));

//        BlogMapper blogMapper = TabuyosSession.getMapper(BlogMapper.class);
////        List<Blog> blogList = blogMapper.queryAll();
//        List<Blog> blogList = blogMapper.queryAll();
////        int blogList = blogMapper.queryID();
//        System.out.println(blogList);


//        Method[] methods = Tabuyos.class.getMethods();
//        for (Method method : methods) {
//            Type genericReturnType = method.getGenericReturnType();
//            System.out.println(genericReturnType.getTypeName());
//            if (genericReturnType instanceof ParameterizedType) {
//                ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
//                System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
//            } else {
//                System.out.println("不是泛型参数");
//            }
//        }

    }
}
