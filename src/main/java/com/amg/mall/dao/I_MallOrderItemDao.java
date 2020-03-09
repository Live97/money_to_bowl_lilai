package com.amg.mall.dao;

import com.amg.mall.domain.MallOrderItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单关联dao接口
 */
@Repository
public interface I_MallOrderItemDao {
	
	/**
	 * 根据id查找订单
	 * @param orderIds
	 * @return
	 */
	List<MallOrderItem> findOrderByIds(@Param("orderIds") List<Integer> orderIds);
	
	/**
	 * 批量插入
	 * @return
	 * @param mallOrderItems
	 */
	int insertBatch(@Param("mallOrderItems") List<MallOrderItem> mallOrderItems);
	
	List<MallOrderItem> findOrderById(Integer order_id);
}
