package com.joinwebsite.blog.api.exception;

import com.alibaba.fastjson.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 标注了@CosmoController，且类及方法上都没有标注@IgnoreCosmoResult的方法才进行包装
        return methodParameter.getDeclaringClass().isAnnotationPresent(CosmoController.class)
                && !methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreCosmoResult.class)
                && !methodParameter.getMethod().isAnnotationPresent(IgnoreCosmoResult.class);
    }

    @Override
    public Object beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        // 如果返回值是Result类型，则不再包装
        if (o instanceof Result) {
            return o;
        }

        // 对String类型特殊处理，返回一个序列化后的json字符串
        if (o instanceof String) {
            return JSON.toJSONString(Result.success(o));
        }

        return Result.success(o);
    }
}