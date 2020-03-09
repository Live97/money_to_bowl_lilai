package com.amg.mall.service;

import com.amg.mall.controller.vo.MallIndexConfigGoodsVO;

import java.util.List;

public interface I_MallIndexConfigService {
	
	
	/**
	 *返回固定数量的首页配置商品对象
	 * @param type
	 * @param number
	 * @return
	 */
	List<MallIndexConfigGoodsVO> getConfigGoodsForIndex(int type,int number);
}
