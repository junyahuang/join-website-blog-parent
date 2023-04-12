package com.joinwebsite.blog.api.service;

import com.joinwebsite.blog.api.entity.VO.BlogInsertVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BlogServiceTest {

    @Autowired
    BlogService blogService;

    //测试增加博客
    @Test
    public void testAdd(){
        BlogInsertVO blogInsertVO = new BlogInsertVO();
        blogInsertVO.setAuthorId(1645486408938328066L);
        blogInsertVO.setBlogCategoryId(1645422756793266178L);
        blogInsertVO.setTitle("test");
        blogInsertVO.setMarkdownContent("### test//abcdefg");
        blogService.addBlog(blogInsertVO);
    }
    //根据id查询用户
    @Test
    public void testFindById(){
        System.out.println(blogService.getBlog(1645986722904850434L));
    }
    //查询所有博客
    @Test
    public void testFindAll(){
        System.out.println(blogService.getBlogList(1,10));
    }

}
