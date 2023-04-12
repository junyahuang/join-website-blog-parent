package com.joinwebsite.blog.api.service;

import com.joinwebsite.blog.api.entity.VO.BlogCategoryNewVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private BlogCategoryService categoryService;

    //测试增加分类
    @Test
    public void testAdd(){
        categoryService.addCategory(new BlogCategoryNewVO("测试分类", 1));
    }
}
