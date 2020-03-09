package com.amg.mall.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 商城用户实体类
 */
public class MallUser  {

    private Integer user_id;

    private String user_nick_name;

    private String introduce_sign;

    private String login_name;

    private String login_password;

    private String address;

    private Byte is_deleted;

    private Byte locked_flag;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date create_time;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_nick_name() {
        return user_nick_name;
    }

    public void setUser_nick_name(String user_nick_name) {
        this.user_nick_name = user_nick_name;
    }

    public String getIntroduce_sign() {
        return introduce_sign;
    }

    public void setIntroduce_sign(String introduce_sign) {
        this.introduce_sign = introduce_sign;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Byte getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Byte is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Byte getLocked_flag() {
        return locked_flag;
    }

    public void setLocked_flag(Byte locked_flag) {
        this.locked_flag = locked_flag;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MallUser{");
        sb.append("user_id=").append(user_id);
        sb.append(", user_nick_name='").append(user_nick_name).append('\'');
        sb.append(", introduce_sign='").append(introduce_sign).append('\'');
        sb.append(", login_name='").append(login_name).append('\'');
        sb.append(", login_password='").append(login_password).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", is_deleted=").append(is_deleted);
        sb.append(", locked_flag=").append(locked_flag);
        sb.append(", create_time=").append(create_time);
        sb.append('}');
        return sb.toString();
    }
}
