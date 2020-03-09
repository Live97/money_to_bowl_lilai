package com.amg.mall.domain;

public class MallStockNumDTO {
	
	private Long goodsId;
	
	private Integer goodsCount;
	
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
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("MallStockNumDTO{");
		sb.append("goodsId=").append(goodsId);
		sb.append(", goodsCount=").append(goodsCount);
		sb.append('}');
		return sb.toString();
	}
}
