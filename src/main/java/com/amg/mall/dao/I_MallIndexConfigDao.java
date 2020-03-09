package com.amg.mall.dao;

import com.amg.mall.domain.MallIndexConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 首页配置dao接口
 */
public interface I_MallIndexConfigDao {
	
	/**
	 *
	 * @param type
	 * @param number
	 * @return
	 */
	List<MallIndexConfig> findIndexConfigByTypeAndNum(@Param("type") int type ,@Param("number") int number);
}
