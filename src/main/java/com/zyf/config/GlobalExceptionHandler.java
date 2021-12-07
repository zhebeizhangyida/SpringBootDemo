package com.zyf.config;

import com.zyf.util.CommonUtil;
import com.zyf.util.Result;
import com.zyf.util.constant.CommonErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 统一异常拦截
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * GET/POST请求方法错误的拦截器
     * 因为开发时可能比较常见,而且发生在进入controller之前,上面的拦截器拦截不到这个错误
     * 所以定义了这个拦截器
     *
     * @param e       异常
     * @param request 请求
     * @return 统一返回接口
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<Object> httpRequestMethodHandler(Exception e, HttpServletRequest request) {
        log.error("url: {}, msg: {}, trace{}", request.getRequestURL(), e.getMessage(), e.getStackTrace());
        return CommonUtil.errorResult(CommonErrorEnum.E_500);
    }

    /**
     * Bad Request请求内容有误的拦截器
     *
     * @param e       异常
     * @param request 请求
     * @return 统一返回接口
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<Object> httpRequestReadableHandler(Exception e, HttpServletRequest request) {
        log.error("url: {}, msg: {}, trace{}", request.getRequestURL(), e.getMessage(), e.getStackTrace());
        return CommonUtil.errorResult(CommonErrorEnum.E_400);
    }

//    /**
//     * 全局任何没有指定拦截器的异常拦截
//     *
//     * @param e       异常
//     * @param request 请求
//     * @return 统一返回接口
//     */
//    @ExceptionHandler(Exception.class)
//    public Result<Object> ExceptionHandler(Exception e, HttpServletRequest request) {
//        log.error("url: {}, msg: {}, trace{}", request.getRequestURL(), e.getMessage(), e.getStackTrace());
//        return CommonUtil.errorResult(CommonErrorEnum.E_500);
//    }

    /**
     * 本系统自定义错误的拦截器
     * 拦截到此错误之后,就返回这个类里面的json给前端
     * 常见使用场景是参数校验失败,抛出此错,返回错误信息给前端
     *
     * @param commonException 异常
     * @return 统一返回接口
     */
    @ExceptionHandler(CommonException.class)
    public Result<Object> commonExceptionHandler(CommonException commonException) {
        return commonException.getResult();
    }

    /**
     * 处理bean violation参数检测异常
     *
     * @param ex 异常
     * @return 统一返回接口
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> resolveMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();
        StringBuilder msgBuilder = new StringBuilder();
        Result<Object> result = new Result<>();
        result.setCode(400);
        for (ObjectError objectError : objectErrors) {
            msgBuilder.append(objectError.getDefaultMessage()).append(",");
        }
        String errorMessage = msgBuilder.toString();
        if (errorMessage.length() > 1) {
            errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
        }
        result.setMsg(errorMessage);
        result.setTimestamp(sdf.format(new Date()));
        return result;
    }
}
