package com.amg.mall.service.impl;

import com.amg.mall.dao.I_AdaminUserDao;
import com.amg.mall.domain.AdminUser;
import com.amg.mall.service.I_AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.MessageDigest;

public class AdminUserServiceImpl implements I_AdminUserService {

    @Autowired
    private I_AdaminUserDao adminUserDao;
    /**
     * 管理员登录方法      ---->   业务层实现类
     * @param login_user_name
     * @param login_password
     * @return
     */
    @Override
    public AdminUser login(String login_user_name ,String login_password) {

        /**
         * 如何进行MD5加密
         */
        return adminUserDao.login(login_user_name, login_password);
    }
}
