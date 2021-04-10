package com.tabuyos.spring.test;

import com.tabuyos.spring.entity.Blog;
import com.tabuyos.spring.factory.BlogDataSourceFactory;
import com.tabuyos.spring.mapper.BlogMapper;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/3/22 10:34
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        // 1
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Blog blog = session.selectOne("com.tabuyos.spring.mapper.BlogMapper.selectBlog", 1);
            System.out.println(blog);
        }
        // 2
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            List<Blog> blog = mapper.selectAll();
            blog.forEach(System.out::println);
        }
    }
}
