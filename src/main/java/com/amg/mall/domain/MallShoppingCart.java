package com.amg.mall.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 购物车实体类
 */
public class MallShoppingCart {
	
	private Long cartItemId;
	
	private Integer userId;
	
	private Long goodsId;
	
	private Integer goodsCount;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updateTime;
	
	private Byte isDeleted;
	
	public Long getCartItemId() {
		return cartItemId;
	}
	
	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Byte getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("MallShoppingCart{");
		sb.append("cartItemId=").append(cartItemId);
		sb.append(", userId=").append(userId);
		sb.append(", goodsId=").append(goodsId);
		sb.append(", goodsCount=").append(goodsCount);
		sb.append(", createTime=").append(createTime);
		sb.append(", updateTime=").append(updateTime);
		sb.append(", isDeleted=").append(isDeleted);
		sb.append('}');
		return sb.toString();
	}
}
