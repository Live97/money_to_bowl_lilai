package com.amg.mall.service.impl;

import com.amg.mall.controller.vo.MallSearchGoodsVO;
import com.amg.mall.dao.I_MallGoodsDao;
import com.amg.mall.domain.MallGoods;
import com.amg.mall.service.I_MallGoodsService;
import com.amg.mall.util.BeanUtil;
import com.amg.mall.util.PageQueryUtil;
import com.amg.mall.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class MallGoodsServiceImpl implements I_MallGoodsService {
	
	@Autowired
	private I_MallGoodsDao mallGoodsDao;
	
	@Override
	public MallGoods findGoodsDetailById(Long goodsId) {
		
		MallGoods goods = mallGoodsDao.findGoodsByPrimaryKey(goodsId);
		
		//cut一下名字长度
		String goodsName = goods.getGoodsName();
		return goods;
	}
	
	@Override
	public PageResult searchGoods(PageQueryUtil pageQueryUtil) {
		
		//查找所有的商品信息
		List<MallGoods> goodsList = mallGoodsDao.findGoodsByKeyWord(pageQueryUtil);
		
		//查询记录条数
		int totalCount = mallGoodsDao.getGoodsCountByKeyWord(pageQueryUtil);
		
		//要将实体类数据转入VO对象中
		List<MallSearchGoodsVO> searchGoodsVOS = new ArrayList<>();
		
		if (!CollectionUtils.isEmpty(goodsList)){
			searchGoodsVOS = BeanUtil.copyList(goodsList, MallSearchGoodsVO.class);
		}
		for (MallSearchGoodsVO searchGoodsVO : searchGoodsVOS) {
			
			//处理一下字符串过长问题
			String goodsName = searchGoodsVO.getGoodsName();
			String goodsIntro = searchGoodsVO.getGoodsIntro();
			
			if (goodsName.length() > 28){
				goodsName = goodsName.substring(0, 28)+"...";
				searchGoodsVO.setGoodsName(goodsName);
			}
			
			if (goodsIntro.length() > 30){
				goodsIntro = goodsIntro.substring(0, 30)+"...";
				searchGoodsVO.setGoodsIntro(goodsIntro);
			}
		}
		System.out.println("searchGoodsVOS = " + searchGoodsVOS);
		System.out.println("totalCount = " + totalCount);
		/**
		 * 总记录数
		 * 当前页码
		 * 每页限制条数
		 * 数据集合
		 */
		PageResult result = new PageResult(
				totalCount,
				pageQueryUtil.getCurrent_page(),
				pageQueryUtil.getLimit(),
				searchGoodsVOS);
		
		return result;
	}
}
