package com.amg.mall.service;

import com.amg.mall.controller.vo.MallIndexCarouselVO;

import java.util.List;

public interface I_MallIndexCarouselService {
	
	
	/**
	 * 返回固定数量的轮播图对象（首页调用）
	 * @param number
	 * @return
	 */
	List<MallIndexCarouselVO> getCarouselForIndex(int number);
}
