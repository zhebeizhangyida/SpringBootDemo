package com.zyf.service;

import com.zyf.entity.User;
import com.zyf.util.Result;

import javax.servlet.http.HttpSession;

/**
 * (User)表服务接口
 *
 * @author zyf
 * @since 2021-12-05 13:13:52
 */
public interface UserService {
    Result<Object> selectById(String id);

    Result<Object> login(User user, HttpSession session);
}
