package com.amg.mall.domain;

import java.io.Serializable;

/**
 * 管理员实体类
 */
public class AdminUser {

    private Integer id;

    private String login_user_name;

    private String login_password;

    private String nick_name;

    private Byte locked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin_user_name() {
        return login_user_name;
    }

    public void setLogin_user_name(String login_user_name) {
        this.login_user_name = login_user_name;
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdminUser{");
        sb.append("id=").append(id);
        sb.append(", login_user_name='").append(login_user_name).append('\'');
        sb.append(", login_password='").append(login_password).append('\'');
        sb.append(", nick_name='").append(nick_name).append('\'');
        sb.append(", locked=").append(locked);
        sb.append('}');
        return sb.toString();
    }
}
