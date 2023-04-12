package com.joinwebsite.blog.api.entity.VO;

import com.joinwebsite.blog.api.enums.DepartmentEnum;
import com.joinwebsite.blog.api.enums.RoleEnum;
import com.joinwebsite.blog.api.enums.SexEnum;
import lombok.Data;

@Data
public class UserInBlogVO {
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
}
