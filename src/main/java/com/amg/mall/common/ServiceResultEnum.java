package com.amg.mall.common;

/**
 * 包含的是业务层操作返回的结果枚举
 */
public enum ServiceResultEnum {

    ERROR("error"),

    SUCCESS("success"),

    DATA_NOT_EXIST("未查询到记录！"),

    SAME_CATALOG_EXIST("有同级同名的分类！"),

    SAME_LOGIN_NAME_EXIST("用户名已存在！"),

    LOGIN_NAME_NULL("请输入用户名！"),

    LOGIN_PASSWORD_NULL("请输入密码！"),
    
    LOGIN_REPASSWORD_NULL("请再次输入密码！"),
    
    TWICE_PASSWORD_NOEQUALS("两次输入的密码不一致！"),

    LOGIN_VERIFY_CODE_NULL("请输入验证码！"),

    LOGIN_VERIFY_CODE_ERROR("验证码错误！"),

    GOODS_NOT_EXIST("商品不存在！"),

    SHOPPING_CART_ITEM_OUT_OF_LIMIT_NUMBER_ERROR("超出单个商品能够购买的数量！"),
    
    SHOPPING_CART_ITEM_OUT_OF_TOTAL_NUMBER_ERROR("超出购物车商品最大购买数量"),

    LOGIN_FAILED("登录失败！用户不存在或密码错误！"),

    LOGIN_USER_LOCKED("用户已被禁止登录！"),

    ORDER_NOT_EXIST_ERROR("订单不存在！"),

    NULL_ADDRESS_ERROR("地址栏不能为空！"),

    ORDER_PRICE_ERROR("订单价格异常！"),

    ORDER_CREATER_ERROR("生成订单异常！"),

    SHOPPING_ITEM_ERROR("购物车数据异常！"),

    SHOPPING_ITEM_COUNT_ERROR("库存不足！"),

    ORDER_STATUS_ERROR("订单状态异常！"),

    OPERATE_ERROR("操作失败！"),

    DB_ERROR("database error");




    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    ServiceResultEnum(String result) {
        this.result = result;
    }


}
