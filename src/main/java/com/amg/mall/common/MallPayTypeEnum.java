package com.amg.mall.common;

/**
 * 订单支付方式枚举值
 */
public enum MallPayTypeEnum {
	
	DEFAULT(-1,"ERROR"),
	NOPAY(0,"无"),
	ALIPAY(1,"支付宝"),
	WECHAT(2,"微信");
	
	
	private int payType;
	private String name;
	
	MallPayTypeEnum(int payType ,String name) {
		this.payType = payType;
		this.name = name;
	}
	public static MallPayTypeEnum getPayTypeString(int payType){
		for (MallPayTypeEnum value : MallPayTypeEnum.values()) {
			
			if (value.getPayType() == payType){
				return value;
			}
		}
		return DEFAULT;
	}
	
	public int getPayType() {
		return payType;
	}
	
	public void setPayType(int payType) {
		this.payType = payType;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
