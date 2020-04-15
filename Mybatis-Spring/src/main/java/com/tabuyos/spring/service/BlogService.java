package com.tabuyos.spring.service;

import com.tabuyos.spring.entity.Blog;
import com.tabuyos.spring.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/3/22 15:55
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Component
public class BlogService {

    BlogMapper blogMapper;

    public BlogService(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    public void queryAll() {
        System.out.println("====================Tabuyos-Separator====================");
        System.out.println(blogMapper.queryAll());
    }
}
