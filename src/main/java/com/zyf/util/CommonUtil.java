package com.zyf.util;

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
     * 返回一个500状态码的json,并附带错误提示。
     *
     * @param msg 错误提示
     * @return 返回result实体
     */
    public static Result<Object> errorResult(String msg) {
        Result<Object> result = new Result<>();
        result.setCode(500);
        result.setMsg(msg);
        result.setTimestamp(sdf.format(new Date()));
        return result;
    }
}
