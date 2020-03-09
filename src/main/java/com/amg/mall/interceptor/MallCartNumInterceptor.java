package com.amg.mall.interceptor;

import com.amg.mall.common.Constants;
import com.amg.mall.controller.vo.MallUserVO;
import com.amg.mall.dao.I_MallShoppingCartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MallCartNumInterceptor implements HandlerInterceptor {
	
	@Autowired
	private I_MallShoppingCartDao mallShoppingCartDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request ,HttpServletResponse response ,Object handler) throws Exception {
		
		/**
		 * 在这里统一对购物车里面存在的商品数量进行管理,前提条件是处于登录状态
		 */
		if (null != request.getSession() && null != request.getSession().getAttribute(Constants.Mall_User_SESSION_KEY)){
			System.out.println("拦截器方法执行了...");
			MallUserVO user = (MallUserVO) request.getSession().getAttribute(Constants.Mall_User_SESSION_KEY);
			user.setShop_cart_item_number(mallShoppingCartDao.findCountByUserId(user.getUser_id()));
			System.out.println("购物车数量: " + user.getShop_cart_item_number());
			request.getSession().setAttribute(Constants.Mall_User_SESSION_KEY, user);
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request ,HttpServletResponse response ,Object handler ,ModelAndView modelAndView) throws Exception {
	
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request ,HttpServletResponse response ,Object handler ,Exception ex) throws Exception {
	
	}
}
