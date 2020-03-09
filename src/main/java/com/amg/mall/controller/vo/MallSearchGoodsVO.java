package com.amg.mall.controller.vo;

/**
 * 搜索商品业务VO对象
 */
public class MallSearchGoodsVO {
	
	private Long goodsId;
	
	private String goodsCoverImg;
	
	private String goodsName;
	
	private String goodsIntro;
	
	private Integer sellingPrice;
	
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
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("MallSearchGoodsVO{");
		sb.append("goodsId=").append(goodsId);
		sb.append(", goodsCoverImg='").append(goodsCoverImg).append('\'');
		sb.append(", goodsName='").append(goodsName).append('\'');
		sb.append(", goodsIntro='").append(goodsIntro).append('\'');
		sb.append(", sellingPrice=").append(sellingPrice);
		sb.append('}');
		return sb.toString();
	}
}
