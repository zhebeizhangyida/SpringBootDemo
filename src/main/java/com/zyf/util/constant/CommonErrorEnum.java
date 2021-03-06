package com.zyf.util.constant;

public enum CommonErrorEnum {
    /**
     * 通用错误信息
     */
    E_400(400, "请求处理异常，请稍后再试"),
    E_500(500, "请求方式有误,请检查 GET/POST"),

    E_1001(1001, "登录失败"),
    E_1002(1002, "请先登录");

    private final Integer errorCode;

    private final String errorMsg;

    CommonErrorEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
