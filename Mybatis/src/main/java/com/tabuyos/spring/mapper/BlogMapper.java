package com.tabuyos.spring.mapper;

import com.tabuyos.spring.entity.Blog;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/3/22 14:02
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public interface BlogMapper {
    @Select("SELECT * FROM blog WHERE id = #{id}")
    Blog selectBlog(int id);

    @Select("SELECT * FROM blog")
    List<Blog> selectAll();
}