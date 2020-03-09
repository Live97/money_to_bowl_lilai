package com.amg.mall.service;

import com.amg.mall.controller.vo.MallUserVO;
import com.amg.mall.domain.MallUser;

import javax.servlet.http.HttpSession;

/**
 * 商城用户业务层接口
 */
public interface I_MallUserService {

    /**
     * 用户登录方法
     * @param login_name
     * @param login_password
     * @param session   需要维持用户登录之后的状态，使用到会话技术
     * @return
     */
    String login(String login_name,String login_password,HttpSession session);
	
	/**
	 * 用户注册方法
	 * @param login_name
	 * @param password
	 * @return
	 */
	String register(String login_name ,String password);
	
	/**
	 * 商城用户修改个人信息接口
	 * @param mallUser
	 * @param session
	 * @return
	 */
    MallUserVO updateUserInfo(MallUser mallUser ,HttpSession session);
}
