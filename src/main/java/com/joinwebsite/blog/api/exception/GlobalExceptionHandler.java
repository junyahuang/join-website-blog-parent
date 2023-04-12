package com.joinwebsite.blog.api.exception;

import com.joinwebsite.blog.api.enums.ExceptionCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sun.security.validator.ValidatorException;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 *
 * @author sunting
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常
     *
     * @param
     * @return
     */
    @ExceptionHandler(BizException.class)
    public Result<ExceptionCodeEnum> handleBizException(BizException bizException) {
        log.error("业务异常:{}", bizException.getMessage(), bizException);
        return Result.error(bizException.getError(), bizException.getMessage());
    }

    /**
     * 运行时异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<ExceptionCodeEnum> handleRunTimeException(RuntimeException e) {
        log.error("运行时异常: {}", e.getMessage(), e);
        return Result.error(ExceptionCodeEnum.ERROR, e.getMessage());
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Result<ExceptionCodeEnum> handleIllegalArgumentException(IllegalArgumentException e) {
        log.warn("参数校验异常: {}", e.getMessage(), e);
        return Result.error(ExceptionCodeEnum.ERROR_PARAM, e.getMessage());
    }
    /**
     * ValidatorUtils校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ValidatorException.class)
    public Result<ExceptionCodeEnum> handleValidatorException(ValidatorException e) {
        log.warn("参数校验异常: {}", e.getMessage(), e);
        return Result.error(ExceptionCodeEnum.ERROR_PARAM, e.getMessage());
    }
    /**
     * ConstraintViolationException异常（散装GET参数校验）
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<ExceptionCodeEnum> handleConstraintViolationException(ConstraintViolationException e) {
        log.warn("参数校验异常: {}", e.getMessage(), e);
        return Result.error(ExceptionCodeEnum.ERROR_PARAM, e.getMessage());
    }
    /**
     * BindException异常（GET DTO校验）
     * @param e
     * @return
     */
    @ExceptionHandler(org.springframework.validation.BindException.class)
    public Result<ExceptionCodeEnum> handleBindException(org.springframework.validation.BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String message = fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(" && "));
        log.error("参数错误: {}", message, e);
        return Result.error(ExceptionCodeEnum.ERROR_PARAM, message);
    }

    /**
     * MethodArgumentNotValidException异常（POST DTO校验）
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<ExceptionCodeEnum> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn("参数校验异常: {}", e.getMessage(), e);
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String message = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
        return Result.error(ExceptionCodeEnum.ERROR_PARAM, message);
    }

}