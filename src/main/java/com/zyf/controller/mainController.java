package com.zyf.controller;

import com.zyf.entity.User;
import com.zyf.service.UserService;
import com.zyf.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("main")
public class mainController {
    @Resource
    private UserService userService;

    @GetMapping("selectById")
    public Result<Object> selectById(String id) {
        return userService.selectById(id);
    }

    @PostMapping("login")
    public Result<Object> login(@RequestBody User user, HttpSession session) {
        return userService.login(user, session);
    }
}
