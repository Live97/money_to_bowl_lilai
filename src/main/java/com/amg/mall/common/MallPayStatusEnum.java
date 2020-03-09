package com.amg.mall.common;

/**
 * 订单支付状态枚举值
 */
public enum MallPayStatusEnum {
	
	DEFAULT(-1,"支付失败"),
	UNPAID(0,"支付中"),
	PAID(1,"支付成功");
	
	
	
	private int pay_status;
	private String name;
	
	MallPayStatusEnum(int pay_status ,String name) {
		this.pay_status = pay_status;
		this.name = name;
	}
	public static MallPayStatusEnum getPayStatusString(int pay_status){
		
		for (MallPayStatusEnum value : MallPayStatusEnum.values()) {
			
			if (value.getPay_status() == pay_status){
				return value;
			}
		}
		return DEFAULT;
	}
	
	public int getPay_status() {
		return pay_status;
	}
	
	public void setPay_status(int pay_status) {
		this.pay_status = pay_status;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
