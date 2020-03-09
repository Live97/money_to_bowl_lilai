package com.amg.mall.controller.vo;

import java.io.Serializable;

/**
 * 商品业务VO
 */
public class MallIndexConfigGoodsVO implements Serializable {
	
	private Long goodsId;
	
	private String goodsName;
	
	private String goodsCoverImg;
	
	private String goodsIntro;
	
	private Integer sellingPrice;
	
	private String tag;
	
	public Long getGoodsId() {
		return goodsId;
	}
	
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public String getGoodsCoverImg() {
		return goodsCoverImg;
	}
	
	public void setGoodsCoverImg(String goodsCoverImg) {
		this.goodsCoverImg = goodsCoverImg;
	}
	
	public String getGoodsIntro() {
		return goodsIntro;
	}
	
	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
	}
	
	public Integer getSellingPrice() {
		return sellingPrice;
	}
	
	public void setSellingPrice(Integer sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("MallIndexConfigGoodsVO{");
		sb.append("goodsId=").append(goodsId);
		sb.append(", goodsName='").append(goodsName).append('\'');
		sb.append(", goodsCoverImg='").append(goodsCoverImg).append('\'');
		sb.append(", goodsIntro='").append(goodsIntro).append('\'');
		sb.append(", sellingPrice=").append(sellingPrice);
		sb.append(", tag='").append(tag).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
