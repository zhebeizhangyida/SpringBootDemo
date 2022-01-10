package com.zyf.service.impl;

import com.zyf.dao.UserDao;
import com.zyf.entity.User;
import com.zyf.service.UserService;
import com.zyf.util.CommonUtil;
import com.zyf.util.RedisUtil;
import com.zyf.util.Result;
import com.zyf.util.constant.CommonErrorEnum;
import com.zyf.util.constant.Constant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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

    @Resource
    private RedisUtil redisUtil;

    @Override
    public Result<Object> selectById(String id) {
        if (redisUtil.hasKey(Constant.Test_KEY + ":" + id)) {
            return CommonUtil.successResult(redisUtil.get(Constant.Test_KEY + ":" + id));
        } else {
            User user = userDao.selectById(id);
            redisUtil.set(Constant.Test_KEY + ":" + id, user, 60 * 60 * 4);
            return CommonUtil.successResult(user);
        }
    }

    @Override
    public Result<Object> login(User user, HttpSession session) {
        User userTemp = userDao.selectByUsername(user.getUsername());
        if (user.getPassword().equals(userTemp.getPassword())) {
            session.setAttribute("loginUserId", userTemp.getId());
            return CommonUtil.successResult(userTemp);
        }
        return CommonUtil.errorResult(CommonErrorEnum.E_1001);
    }
}
