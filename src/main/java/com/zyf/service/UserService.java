package com.zyf.service;

import com.zyf.entity.User;

/**
 * (User)表服务接口
 *
 * @author zyf
 * @since 2021-12-05 13:13:52
 */
public interface UserService {
    User selectById(String id);

    int insert(User user);

    int updateById(User user);
}
