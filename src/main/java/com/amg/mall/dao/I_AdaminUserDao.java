package com.amg.mall.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.amg.mall.domain.AdminUser;

/**
 * 管理员dao接口
 */
@Repository
public interface I_AdaminUserDao {

    /**
     * 管理员登录方法
     *
     * @param login_user_name
     * @param login_password
     * @return
     */
    AdminUser login(String login_user_name ,String login_password);
}
