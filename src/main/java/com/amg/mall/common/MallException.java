package com.amg.mall.common;

/**
 * 捕获异常
 */
public class MallException extends RuntimeException {
	
	public MallException() {
	}
	
	public MallException(String message){
		super(message);
	}
	
	public static void fail(String message) {
		throw new MallException(message);
	}
}
