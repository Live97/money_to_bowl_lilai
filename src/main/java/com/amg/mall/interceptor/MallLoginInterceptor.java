package com.amg.mall.interceptor;

import com.amg.mall.common.Constants;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 商城登录拦截器
 */
public class MallLoginInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request ,HttpServletResponse response ,Object handler) throws Exception {
        
        //session中没有这个属性代表用户尚未登录
        if (request.getSession().getAttribute(Constants.Mall_User_SESSION_KEY) == null){
            //重定向到登录页面
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public void postHandle(HttpServletRequest request ,HttpServletResponse response ,Object handler ,ModelAndView modelAndView) throws Exception {
    
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request ,HttpServletResponse response ,Object handler ,Exception ex) throws Exception {
    
    }
}
