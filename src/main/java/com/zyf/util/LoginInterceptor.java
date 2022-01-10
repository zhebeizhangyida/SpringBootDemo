package com.zyf.util;

import com.alibaba.fastjson.JSON;
import com.zyf.util.constant.CommonErrorEnum;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 登陆检查
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行前
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理器
     * @return 放行或拦截
     * @throws Exception 抛出异常
     */
    @Override
    @ResponseBody
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆session认证
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUserId");
        if (loginUser != null)
            //放行
            return true;
        //拦截
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        Result<Object> result = CommonUtil.errorResult(CommonErrorEnum.E_1002);
        String json = JSON.toJSONString(result);
        response.getWriter().print(json);
        return false;
    }

    /**
     * 目标方法完成后
     *
     * @param request      请求
     * @param response     响应
     * @param handler      处理器
     * @param modelAndView 视图
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    /**
     * 页面渲染后
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理器
     * @param ex       异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}

