package com.amg.mall.service.impl;

import com.amg.mall.controller.vo.MallIndexCarouselVO;
import com.amg.mall.dao.I_MallIndexCarouselDao;
import com.amg.mall.domain.MallCarousel;
import com.amg.mall.service.I_MallIndexCarouselService;
import com.amg.mall.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class MallIndexCarouselServiceImpl implements I_MallIndexCarouselService {
	
	@Autowired
	private I_MallIndexCarouselDao mallIndexCarouselDao;
	
	@Override
	public List<MallIndexCarouselVO> getCarouselForIndex(int number) {
		
		List<MallIndexCarouselVO> mallIndexCarouselVOS = new ArrayList<>(number);
		List<MallCarousel> mallCarousels = mallIndexCarouselDao.findCarouselsByNum(number);
		
		//如果有数据，直接把数据传给VO对象
		if (!CollectionUtils.isEmpty(mallCarousels)) {
			mallIndexCarouselVOS = BeanUtil.copyList(mallCarousels, MallIndexCarouselVO.class);
		}
		return mallIndexCarouselVOS;
	}
}
