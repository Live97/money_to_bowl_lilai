package com.amg.mall.controller.vo;

import java.io.Serializable;

/**
 * 首页轮播图VO
 */
public class MallIndexCarouselVO implements Serializable {
	
	private String carouselUrl;
	
	private String redirectUrl;
	
	public String getCarouselUrl() {
		return carouselUrl;
	}
	
	public void setCarouselUrl(String carouselUrl) {
		this.carouselUrl = carouselUrl;
	}
	
	public String getRedirectUrl() {
		return redirectUrl;
	}
	
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("MallIndexCarouselVO{");
		sb.append("carouselUrl='").append(carouselUrl).append('\'');
		sb.append(", redirectUrl='").append(redirectUrl).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
