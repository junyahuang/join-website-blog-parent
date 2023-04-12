package com.joinwebsite.blog.api.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.joinwebsite.blog.api.entity.VO.UserInsertVO;
import com.joinwebsite.blog.api.entity.PO.UserPO;

public interface UserService {
    /**
     * 新增一名用户
     * @param userInsertVO
     * @return
     */
    boolean addUser(UserInsertVO userInsertVO);

    /**
     * 分页查询所有用户
     * @param current
     * @param size
     * @return
     */
    IPage<UserPO> findAllUser(int current, int size);

    UserPO findUserById(Long id);
}
