package com.amg.mall.service.impl;

import com.amg.mall.controller.vo.MallIndexConfigGoodsVO;
import com.amg.mall.dao.I_MallGoodsDao;
import com.amg.mall.dao.I_MallIndexConfigDao;
import com.amg.mall.domain.MallGoods;
import com.amg.mall.domain.MallIndexConfig;
import com.amg.mall.service.I_MallIndexConfigService;
import com.amg.mall.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MallIndexConfigServiceImpl implements I_MallIndexConfigService {
	
	@Autowired
	private I_MallIndexConfigDao mallindexConfigDao;
	
	@Autowired
	private I_MallGoodsDao mallGoodsDao;
	
	@Override
	public List<MallIndexConfigGoodsVO> getConfigGoodsForIndex(int type ,int number) {
		
		List<MallIndexConfigGoodsVO> mallIndexConfigGoodsVOS = new ArrayList<>(number);
		List<MallIndexConfig> mallIndexConfigs = mallindexConfigDao.findIndexConfigByTypeAndNum(type ,number);
		
		//查询有结果
		if (!CollectionUtils.isEmpty(mallIndexConfigs)) {
			
			//取出所有的商品id
			List<Long> goodIds = mallIndexConfigs.stream().map(MallIndexConfig::getGoodsId).collect(Collectors.toList());
			//根据id查询出来所有的商品信息，将数据从实体类转给VO对象
			List<MallGoods> mallGoods = mallGoodsDao.findGoodsByPrimaryKeys(goodIds);
			
			mallIndexConfigGoodsVOS = BeanUtil.copyList(mallGoods ,MallIndexConfigGoodsVO.class);
			for (MallIndexConfigGoodsVO mallIndexConfigGoodsVO : mallIndexConfigGoodsVOS) {
				
				String goodsName = mallIndexConfigGoodsVO.getGoodsName();
				String goodsIntro = mallIndexConfigGoodsVO.getGoodsIntro();
				
				//字符串太长导致文字超出的问题
				if (goodsName.length() > 30) {
					goodsName = goodsName.substring(0 ,30) + "...";
					mallIndexConfigGoodsVO.setGoodsName(goodsName);
				}
				if (goodsIntro.length() > 22) {
					goodsIntro = goodsIntro.substring(0 ,22) + "...";
					mallIndexConfigGoodsVO.setGoodsIntro(goodsIntro);
				}
			}
		}
		return mallIndexConfigGoodsVOS;
	}
}
