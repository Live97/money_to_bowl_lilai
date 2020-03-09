package com.amg.mall.service;

import com.amg.mall.domain.MallGoods;
import com.amg.mall.util.PageQueryUtil;
import com.amg.mall.util.PageResult;

/**
 * 商品业务层接口
 */
public interface I_MallGoodsService {
	
	
	/**
	 * 获取商品详情数据
	 * @param goodsId
	 * @return
	 */
	MallGoods findGoodsDetailById(Long goodsId);
	
	/**
	 * 搜索商品
	 * @param pageQueryUtil
	 * @return
	 */
	PageResult searchGoods(PageQueryUtil pageQueryUtil);
}
