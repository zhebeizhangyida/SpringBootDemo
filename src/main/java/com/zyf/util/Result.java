package com.zyf.util;

import lombok.Data;

@Data
public class Result<T> {
    /**
     * 返回代码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 服务器当前时间戳
     */
    private String timestamp;

    /**
     * 成功数据
     */
    private T data;
}
