package com.amg.mall.controller.vo;


import java.io.Serializable;
import java.util.Arrays;

/**
 * 商品详情页面VO对象
 */
public class MallGoodsDetailVO implements Serializable {
	
	
	//商品编号
	private Long goodsId;
	
	//商品图片(大图)
	private String goodsCoverImg;
	
	//商品名字
	private String goodsName;
	
	//商品轮播图
	private String[] goodsCarouselList;
	
	//商品原始价格
	private Integer originalPrice;
	
	//商品现售价格
	private Integer sellingPrice;
	
	//商品介绍
	private String goodsIntro;
	
	//商品详情
	private String goodsDetailContent;
	
	public Long getGoodsId() {
		return goodsId;
	}
	
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
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
	
	public String[] getGoodsCarouselList() {
		return goodsCarouselList;
	}
	
	public void setGoodsCarouselList(String[] goodsCarouselList) {
		this.goodsCarouselList = goodsCarouselList;
	}
	
	public Integer getOriginalPrice() {
		return originalPrice;
	}
	
	public void setOriginalPrice(Integer originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	public Integer getSellingPrice() {
		return sellingPrice;
	}
	
	public void setSellingPrice(Integer sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	public String getGoodsIntro() {
		return goodsIntro;
	}
	
	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
	}
	
	public String getGoodsDetailContent() {
		return goodsDetailContent;
	}
	
	public void setGoodsDetailContent(String goodsDetailContent) {
		this.goodsDetailContent = goodsDetailContent;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("MallGoodsDetailVO{");
		sb.append("goodsId=").append(goodsId);
		sb.append(", goodsCoverImg='").append(goodsCoverImg).append('\'');
		sb.append(", goodsName='").append(goodsName).append('\'');
		sb.append(", goodsCarouselList=").append(Arrays.toString(goodsCarouselList));
		sb.append(", originalPrice=").append(originalPrice);
		sb.append(", sellingPrice=").append(sellingPrice);
		sb.append(", goodsIntro='").append(goodsIntro).append('\'');
		sb.append(", goodsDetailContent='").append(goodsDetailContent).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
