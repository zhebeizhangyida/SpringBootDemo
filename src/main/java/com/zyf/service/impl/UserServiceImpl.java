package com.zyf.service.impl;

import com.zyf.dao.UserDao;
import com.zyf.entity.User;
import com.zyf.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author zyf
 * @since 2021-12-05 13:13:52
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User selectById(String id) {
        return userDao.selectById(id);
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int updateById(User user) {
        return 0;
    }
}
