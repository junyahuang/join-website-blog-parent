package com.joinwebsite.blog.api.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum DepartmentEnum {
    FRONTEND(1, "前端"),
    BACKEND(2, "后端"),
    PRODUCT(3, "产品"),
    DESIGN(4, "设计"),
    FRONTEND_INTERNSHIP(5, "前端实习生"),
    BACKEND_INTERNSHIP(6, "后端实习生"),
    PRODUCT_INTERNSHIP(7, "产品实习生"),
    DESIGN_INTERNSHIP(8, "设计实习生"),
    ;

    DepartmentEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @EnumValue
    private final int code;
    private final String desc;

    public static DepartmentEnum getEnumByDesc(String desc) {
        for (DepartmentEnum departmentEnum : DepartmentEnum.values()) {
            if (departmentEnum.getDesc().equals(desc)) {
                return departmentEnum;
            }
        }
        throw new IllegalArgumentException("不支持的部门类型");
    }

    @JsonValue
    public Map result() {
        Map map = new HashMap();
        map.put("code", code);
        map.put("desc", desc);
        return map;
    }

}