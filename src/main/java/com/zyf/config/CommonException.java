package com.zyf.config;

import com.zyf.util.CommonUtil;
import com.zyf.util.Result;
import com.zyf.util.constant.CommonErrorEnum;

/**
 * 本系统使用的自定义错误类
 * 比如在校验参数时,如果不符合要求,可以抛出此错误类
 * 拦截器可以统一拦截此错误,将其中json返回给前端
 */
public class CommonException extends RuntimeException {
    final Result<Object> result;

    /**
     * 调用时可以在任何代码处直接throws这个Exception,
     * 都会统一被拦截,并封装好json返回给前台
     */
    public CommonException(Result<Object> result) {
        this.result = result;
    }

    /**
     * 调用时可以在任何代码处直接throws这个Exception,
     * 都会统一被拦截,并封装好json返回给前台
     */
    public CommonException(CommonErrorEnum commonErrorEnum) {
        this.result = CommonUtil.errorResult(commonErrorEnum);
    }

    public Result<Object> getResult() {
        return result;
    }
}
