package com.joinwebsite.blog.api.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.joinwebsite.blog.api.entity.PO.UserPO;
import com.joinwebsite.blog.api.entity.VO.UserInsertVO;
import com.joinwebsite.blog.api.exception.CosmoController;
import com.joinwebsite.blog.api.exception.Result;
import com.joinwebsite.blog.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@CosmoController
@CrossOrigin
@RequestMapping("/users")
/**
 * 用户管理Controller
 */
@Api(value = "用户管理Controller",tags = "用户管理接口")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 新增一名用户
     */
    @ApiOperation(value = "新增一名用户",notes = "新增一名用户",httpMethod = "POST")
    @PostMapping
    public Result<Object> addUser(@ApiParam(name = "用户信息")
            @RequestBody UserInsertVO userInsertVO){
        userService.addUser(userInsertVO);
        return Result.success();
    }

    /**
     * 分页查询用户
     */
    @GetMapping("/{currentPage}/{pageSize}")
    @ApiOperation(value = "分页查询用户",notes = "分页查询用户",httpMethod = "GET")
    public Result<Object> queryUser(
            @ApiParam(name = "当前页码") @PathVariable("currentPage") int currentPage,
                                    @ApiParam(name = "每页数量") @PathVariable("pageSize") int pageSize){
        //TODO
        IPage<UserPO> allUser = userService.findAllUser(currentPage, pageSize);
        return Result.success(allUser);
    }
}
