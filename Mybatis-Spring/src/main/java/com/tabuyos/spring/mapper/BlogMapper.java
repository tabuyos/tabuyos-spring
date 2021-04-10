package com.tabuyos.spring.mapper;

import com.tabuyos.spring.entity.Blog;
import com.tabuyos.spring.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Tabuyos
 * @Time 2020/3/22 14:02
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public interface BlogMapper {
    @Select("select * from blog where id = #{id}")
    Blog queryBlogByID(int id);

    @Select("select * from blog")
    List<Blog> queryAll();

    @Select("select id from blog where id = 1")
    Integer queryID();
}