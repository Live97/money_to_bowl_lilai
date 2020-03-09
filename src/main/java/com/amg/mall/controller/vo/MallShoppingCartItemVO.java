package com.amg.mall.controller.vo;

import java.io.Serializable;

/**
 * 用户购物车VO对象
 */
public class MallShoppingCartItemVO implements Serializable {
	
	private Long cartItemId;
	
	private Long goodsId;
	
	private Integer goodsCount;
	
	private Integer sellingPrice;
	
	private String goodsCoverImg;
	
	private String goodsName;
	
	public Long getCartItemId() {
		return cartItemId;
	}
	
	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}
	
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
	
	public String getGoodsName() {
		return goodsName;
	}
	
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("MallShoppingCartItemVO{");
		sb.append("cartItemId=").append(cartItemId);
		sb.append(", goodsId=").append(goodsId);
		sb.append(", goodsCount=").append(goodsCount);
		sb.append(", sellingPrice=").append(sellingPrice);
		sb.append(", goodsCoverImg='").append(goodsCoverImg).append('\'');
		sb.append(", goodsName='").append(goodsName).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
