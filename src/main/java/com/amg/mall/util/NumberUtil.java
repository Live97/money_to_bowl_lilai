package com.amg.mall.util;

import java.util.Random;

public class NumberUtil {
	
	/**
	 * 生成指定长度的随机数
	 */
	public static int genRandom(int length){
		
		int num = 1;
		
		double random = Math.random() + 1;
		
		for (int i = 0; i < length; i++) {
			num *= 10;
		}
		return (int) (random*num);
	}
	
	/**
	 * 生成唯一订单号
	 * @return
	 */
	public static String genOrderNo(){
		
		//初始化StringBuffer,使用系统当前时间戳
		StringBuffer stringBuffer = new StringBuffer(String.valueOf(System.currentTimeMillis()));
		stringBuffer.append(genRandom(4));
		return stringBuffer.toString();
	}
}
