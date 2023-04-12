package com.joinwebsite.blog.api.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum RoleEnum {
    ADMIN(0, "管理员"),
    //工作室正式用户
    MEMBER(1, "正式成员"),
    //工作室实习成员
    INTERNSHIP(2, "实习成员"),
    ;

    RoleEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @EnumValue
    private final int code;
    private final String desc;

    @JsonValue
    public Map result() {
        Map map = new HashMap();
        map.put("code", code);
        map.put("desc", desc);
        return map;
    }
    //通过desc获取枚举
    public static RoleEnum getEnumByDesc(String desc) {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            if (roleEnum.getDesc().equals(desc)) {
                return roleEnum;
            }
        }
        throw new IllegalArgumentException("不支持的用户角色类型");
    }
}