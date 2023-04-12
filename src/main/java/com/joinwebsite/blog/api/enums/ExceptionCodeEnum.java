package com.joinwebsite.blog.api.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Getter
public enum ExceptionCodeEnum {
    /**
     * 通用结果
     */
    ERROR(400, "错误"),
    ERROR_UNKNOWN(-1, "未知错误"),
    ERROR_INTERNAL_SERVER(500, "服务器内部错误"),
    SUCCESS(200, "成功"),
    UNAUTHORIZED(401, "没有权限"),
    FORBIDDEN(403, "被禁止"),
    NOT_FOUND(404, "资源不存在"),


    /**
     * 用户登录
     */
    NEED_LOGIN(900, "用户未登录"),

    /**
     * 参数校验
     */
    ERROR_PARAM(10000, "参数错误"),
    EMPTY_PARAM(10001, "参数为空"),
    ERROR_PARAM_LENGTH(10002, "参数长度错误");
    private final Integer code;
    private final String desc;

    ExceptionCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private static final Map<Integer, ExceptionCodeEnum> ENUM_CACHE = new HashMap<>();

    static {
        for (ExceptionCodeEnum exceptionCodeEnum : ExceptionCodeEnum.values()) {
            ENUM_CACHE.put(exceptionCodeEnum.code, exceptionCodeEnum);
        }
    }

    public static String getDesc(Integer code) {
        return Optional.ofNullable(ENUM_CACHE.get(code))
                .map(ExceptionCodeEnum::getDesc)
                .orElseThrow(() -> new IllegalArgumentException("invalid exception code!"));
    }
}
