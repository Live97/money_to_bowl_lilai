package com.amg.mall.controller.vo;

import java.io.Serializable;

/**
 * 订单详情页面页面订单项VO，存放的是订单里每件商品的必要业务信息
 */
public class MallOrderItemVO implements Serializable {
    
    private Long goodsId;
    
    private Integer goodsCount;
    
    private String goodsName;
    
    private Integer sellingPrice;
    
    private String goodsCoverImg;
    
    public Long getGoodsId() {
        return goodsId;
    }
    
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
    
    public Integer getGoodsCount() {
        return goodsCount;
    }
    
    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }
    
    public String getGoodsName() {
        return goodsName;
    }
    
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    
    public Integer getSellingPrice() {
        return sellingPrice;
    }
    
    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    
    public String getGoodsCoverImg() {
        return goodsCoverImg;
    }
    
    public void setGoodsCoverImg(String goodsCoverImg) {
        this.goodsCoverImg = goodsCoverImg;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MallOrderItemVO{");
        sb.append("goodsId=").append(goodsId);
        sb.append(", goodsCount=").append(goodsCount);
        sb.append(", goodsName='").append(goodsName).append('\'');
        sb.append(", sellingPrice=").append(sellingPrice);
        sb.append(", goodsCoverImg='").append(goodsCoverImg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
