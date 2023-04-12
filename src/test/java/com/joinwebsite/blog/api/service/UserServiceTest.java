package com.joinwebsite.blog.api.service;

import com.joinwebsite.blog.api.entity.VO.UserInsertVO;
import com.joinwebsite.blog.api.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;

    //测试增加用户
    @Test
    public void testAdd(){
        //新建UserNewVO
        UserInsertVO userInsertVO = new UserInsertVO();
        userInsertVO.setLoginId("test");
        userInsertVO.setLoginPassword("test");
        userInsertVO.setName("test");
        userInsertVO.setSex("男");
        userInsertVO.setRole("管理员");
        userInsertVO.setAvatar("test");
        userInsertVO.setPhone("test");
        userInsertVO.setEmail("test");
        userInsertVO.setDepartment("后端");
        //调用service
        userService.addUser(userInsertVO);
    }
    //查询所有用户
    @Test
    public void testFindAll(){
        System.out.println(userMapper.selectList(null));
    }

}
