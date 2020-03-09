package com.amg.mall.dao;

import com.amg.mall.domain.MallCarousel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 轮播图dao接口
 */
public interface I_MallIndexCarouselDao {
	
	/**
	 * 返回固定数量的轮播图供前台调用
	 * @param number
	 * @return
	 */
	List<MallCarousel> findCarouselsByNum(@Param("number") int number);
}
