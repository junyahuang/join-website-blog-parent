package com.joinwebsite.blog.api.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum SexEnum {
    MAN(0, "男"),
    WOMAN(1, "女"),
    //保密
    NOT_KNOW(2, "保密")
    ;

    SexEnum(int code, String desc) {
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
    public static SexEnum getEnumByDesc(String desc) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.getDesc().equals(desc)) {
                return sexEnum;
            }
        }
        throw new IllegalArgumentException("不支持的性别类型");
    }

}