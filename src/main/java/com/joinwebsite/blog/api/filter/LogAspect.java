package com.joinwebsite.blog.api.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LogAspect{
    private static final Log LOG = LogFactory.getLog(LogAspect.class);
    @Pointcut("execution(* com.joinwebsite.blog.api.controller..*.*(..))")
    public void logPointcut() {
    }
    @org.aspectj.lang.annotation.Around("logPointcut()")
    public Object AutoLogAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOG.info("=====================================request start====================================");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        long start = System.currentTimeMillis();
        try {
            Object result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            String token = request.getHeader("token");// 从 http 请求头中取出 token
            LOG.info("token:" + token);
            LOG.info("请求地址:" + request.getRequestURI());
            LOG.info("用户IP:" + request.getRemoteAddr());
            LOG.info("CLASS_METHOD : " + proceedingJoinPoint.getSignature().getDeclaringTypeName() + "." + proceedingJoinPoint.getSignature().getName());
            LOG.info("参数: " + Arrays.toString(proceedingJoinPoint.getArgs()));
            LOG.info("执行时间: " + (end - start) + " ms");
            LOG.info("=====================================request end====================================");
            return result;
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            LOG.info("请求地址:" + request.getRequestURI());
            LOG.info("用户IP:" + request.getRemoteAddr());
            LOG.info("CLASS_METHOD : " + proceedingJoinPoint.getSignature().getDeclaringTypeName() + "." + proceedingJoinPoint.getSignature().getName());
            LOG.info("参数 : " + Arrays.toString(proceedingJoinPoint.getArgs()));
            LOG.info("执行时间: " + (end - start) + " ms!");
            LOG.info("=====================================request end====================================");
            throw e;
        }
    }
}