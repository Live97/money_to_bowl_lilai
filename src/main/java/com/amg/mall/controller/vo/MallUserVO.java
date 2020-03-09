package com.amg.mall.controller.vo;


import java.io.Serializable;

/**
 * 根据业务层操作，存取数据的地方
 */
public class MallUserVO implements Serializable {
    
    private Integer user_id;
    
    private String user_nick_name;
    
    private String introduce_sign;
    
    private String address;
    
    private String login_name;
    
    private Integer shop_cart_item_number;
    
    
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
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getLogin_name() {
        return login_name;
    }
    
    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }
    
    public Integer getShop_cart_item_number() {
        return shop_cart_item_number;
    }
    
    public void setShop_cart_item_number(Integer shop_cart_item_number) {
        this.shop_cart_item_number = shop_cart_item_number;
    }
}
