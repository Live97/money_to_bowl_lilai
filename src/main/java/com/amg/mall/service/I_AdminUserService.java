package com.amg.mall.service;

import com.amg.mall.domain.AdminUser;

/**
 * 管理员业务层接口
 */
public interface I_AdminUserService {

    /**
     * 管理员登录方法
     * @param login_user_name
     * @param login_password
     * @return
     */
    AdminUser login(String login_user_name,String login_password);
}
