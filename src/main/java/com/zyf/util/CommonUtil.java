package com.zyf.util;

import com.zyf.util.constant.CommonErrorEnum;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Result<Object> successResult() {
        Result<Object> result = new Result<>();
        result.setCode(200);
        result.setMsg("请求成功");
        result.setTimestamp(sdf.format(new Date()));
        return result;
    }

    /**
     * 返回一个带有数据的返回状态码为200的json
     *
     * @param data 具体数据
     * @return 返回result实体
     */
    public static Result<Object> successResult(Object data) {
        Result<Object> result = new Result<>();
        result.setCode(200);
        result.setMsg("请求成功");
        result.setTimestamp(sdf.format(new Date()));
        result.setData(data);
        return result;
    }

    /**
     * 返回一个带有错误信息码的json
     *
     * @param errorEnum 错误信息类型
     * @return 返回result实体
     */
    public static Result<Object> errorResult(CommonErrorEnum errorEnum) {
        Result<Object> result = new Result<>();
        result.setCode(errorEnum.getErrorCode());
        result.setMsg(errorEnum.getErrorMsg());
        result.setTimestamp(sdf.format(new Date()));
        return result;
    }
}
