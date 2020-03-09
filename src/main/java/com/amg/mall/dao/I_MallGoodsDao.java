package com.amg.mall.dao;

import com.amg.mall.domain.MallGoods;
import com.amg.mall.domain.MallStockNumDTO;
import com.amg.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品dao接口
 */
public interface I_MallGoodsDao {
	
	/**
	 * 根据主键查找所有商品信息
	 * @param goodIds
	 * @return
	 */
	List<MallGoods> findGoodsByPrimaryKeys(List<Long> goodIds);
	
	/**
	 * 根据主键查找单个商品信息
	 * @param goodsId
	 * @return
	 */
	MallGoods findGoodsByPrimaryKey(@Param("goodsId") Long goodsId);
	
	/**
	 * 根据关键词查找所有商品信息
	 * @param pageQueryUtil
	 * @return
	 */
	List<MallGoods> findGoodsByKeyWord(PageQueryUtil pageQueryUtil);
	
	/**
	 * 根据关键词查找有多少条记录
	 * @param pageQueryUtil
	 * @return
	 */
	int getGoodsCountByKeyWord(PageQueryUtil pageQueryUtil);
	
	/**
	 * 更新库存
	 * @param stockNumDTOS
	 * @return
	 */
	int updateStockNum(List<MallStockNumDTO> stockNumDTOS);
}
