package com.joinwebsite.blog.api.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joinwebsite.blog.api.entity.VO.UserInsertVO;
import com.joinwebsite.blog.api.entity.PO.UserPO;
import com.joinwebsite.blog.api.enums.DepartmentEnum;
import com.joinwebsite.blog.api.enums.RoleEnum;
import com.joinwebsite.blog.api.enums.SexEnum;
import com.joinwebsite.blog.api.mapper.UserMapper;
import com.joinwebsite.blog.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 新增一名用户
     *
     * @param userInsertVO
     * @return
     */
    @Override
    public boolean addUser(UserInsertVO userInsertVO) {
        //封装userPO
        UserPO userPO = new UserPO();
        userPO.setLoginId(userInsertVO.getLoginId());
        userPO.setLoginPassword(userInsertVO.getLoginPassword());
        userPO.setName(userInsertVO.getName());
        userPO.setSex(SexEnum.getEnumByDesc(userInsertVO.getSex()));
        userPO.setRole(RoleEnum.getEnumByDesc(userInsertVO.getRole()));
        userPO.setAvatar(userInsertVO.getAvatar());
        userPO.setPhone(userInsertVO.getPhone());
        userPO.setEmail(userInsertVO.getEmail());
        userPO.setDepartment(DepartmentEnum.getEnumByDesc(userInsertVO.getDepartment()));
        return userMapper.insert(userPO) > 0;
    }

    /**
     * 分页查询所有用户
     *
     * @param current
     * @param size
     * @return
     */
    @Override
    public IPage<UserPO> findAllUser(int current, int size) {
        //封装page
        Page page = new Page(current, size);
        //查询所有用户
        return userMapper.selectPage(page, null);
    }
    /**
     * 根据id查找用户
     */
    @Override
    public UserPO findUserById(Long id) {
        UserPO userPO = userMapper.selectById(id);
        //如果没有找到用户
        if (userPO == null) {
            log.error("没有找到id为{}的用户", id);
            throw new RuntimeException("没有找到id为" + id + "的用户");
        }
        return userPO;
    }

}
