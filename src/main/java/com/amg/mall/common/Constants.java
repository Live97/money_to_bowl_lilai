package com.amg.mall.common;

/**
 * 常量设置
 */
public class Constants {
    
    //session中商城用户的key值
    public static final String Mall_User_SESSION_KEY = "MallUser";
    
    //验证码key
    public static final String MALL_VERIFY_CODE_KEY = "mallVerifyCode";
    
    //订单分页条数限制
    public static final Integer ORDER_SEARCH_PAGE_LIMIT = 3;
    
    //首页轮播图数量（可以根据需要修改）
    public static final Integer INDEX_CAROUSEL_NUMBER = 5;
    
    //首页热销商品数量
    public static final Integer INDEX_GOODS_HOT_NUMBER = 4;
    
    //首页最新商品数量
    public static final Integer INDEX_GOODS_NEW_NUMBER = 5;
    
    //首页为你推荐商品数量
    public static final Integer INDEX_GOODS_RECOMMOND_NUMBER = 10;
    
    //购物车中单个商品最多可以购买数量（可修改）
    public static final Integer SHOPPING_CART_ITEM_LIMIT_NUMBER = 5;
    
    //购物车中商品的最大数量（可修改）
    public static final Integer SHOPPING_CART_ITEM_TOTAL_NUMBER = 5;
    
    //搜索商品页面最多显示的条数
    public static final Integer GOODS_SEARCH_PAGE_LIMIT = 10;
}
