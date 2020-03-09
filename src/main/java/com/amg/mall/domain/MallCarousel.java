package com.amg.mall.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 轮播图实体类
 */
public class MallCarousel {
	
	private Integer carouselId;
	
	private String carouselUrl;
	
	private String redirectUrl;
	
	private Integer carouselRank;
	
	private Byte isDeleted;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;
	
	private Integer createUser;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updateTime;
	
	private Integer updateUser;
	
	public Integer getCarouselId() {
		return carouselId;
	}
	
	public void setCarouselId(Integer carouselId) {
		this.carouselId = carouselId;
	}
	
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
	
	public Integer getCarouselRank() {
		return carouselRank;
	}
	
	public void setCarouselRank(Integer carouselRank) {
		this.carouselRank = carouselRank;
	}
	
	public Byte getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Integer getCreateUser() {
		return createUser;
	}
	
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Integer getUpdateUser() {
		return updateUser;
	}
	
	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("MallCarousel{");
		sb.append("carouselId=").append(carouselId);
		sb.append(", carouselUrl='").append(carouselUrl).append('\'');
		sb.append(", redirectUrl='").append(redirectUrl).append('\'');
		sb.append(", carouselRank=").append(carouselRank);
		sb.append(", isDeleted=").append(isDeleted);
		sb.append(", createTime=").append(createTime);
		sb.append(", createUser=").append(createUser);
		sb.append(", updateTime=").append(updateTime);
		sb.append(", updateUser=").append(updateUser);
		sb.append('}');
		return sb.toString();
	}
}
