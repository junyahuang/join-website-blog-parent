package com.joinwebsite.blog.api.entity.PO;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.joinwebsite.blog.api.enums.DepartmentEnum;
import com.joinwebsite.blog.api.enums.RoleEnum;
import com.joinwebsite.blog.api.enums.SexEnum;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_user")
public class UserPO {
    private Long id;
    private String loginId;
    private String loginPassword;
    private String name;
    private SexEnum sex;
    private String email;
    private String avatar;
    private String description;
    private RoleEnum role;
    private String phone;
    private DepartmentEnum department;
    private int grade;
    // 0:正常 1:禁用
    @TableField(fill = FieldFill.INSERT)
    private int isDeleted;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

}
