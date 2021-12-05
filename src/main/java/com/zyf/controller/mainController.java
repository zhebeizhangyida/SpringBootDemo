package com.zyf.controller;

import com.zyf.service.UserService;
import com.zyf.util.CommonUtil;
import com.zyf.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("main")
public class mainController {
    @Resource
    private UserService userService;

    @GetMapping("selectById")
    public Result<Object> selectById(String id) {
        return CommonUtil.successResult(userService.selectById(id));
    }
}
