package com.zyf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyf.entity.User;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * (User)表数据库访问层
 *
 * @author zyf
 * @since 2021-12-05 13:13:45
 */
public interface UserDao extends BaseMapper<User> {

    @Override
    User selectById(Serializable id);

    @Override
    int updateById(@Param("et") User user);

    @Override
    int insert(User entity);
}

