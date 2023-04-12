package com.joinwebsite.blog.api.entity.VO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 用于接收前端传来的新建用户信息
 */
@Data
@Api(value = "新增用户信息")
public class UserInsertVO {
    @ApiParam(value = "登录账号", required = true)
    private String loginId;
    @ApiParam(value = "登录密码", required = true)
    private String loginPassword;
    @ApiParam(value = "用户姓名", required = true)
    private String name;
    @ApiParam(value = "用户性别",allowableValues = "男,女,保密", required = true)
    private String sex;
    @ApiParam(value = "用户邮箱")
    private String email;
    @ApiParam(value = "用户头像")
    private String avatar;
    @ApiParam(value = "用户描述")
    private String description;
    @ApiParam(value = "用户角色",allowableValues = "管理员,普通用户", required = true)
    private String role;
    @ApiParam(value = "用户手机号")
    private String phone;
    @ApiParam(value = "用户部门",
            allowableValues = "前端,后端,产品,设计,前端实习生,后端实习生,产品实习生,设计实习生",
            required = true)
    private String department;
    @ApiParam(value = "用户年级",required = true)
    private int grade;
}
