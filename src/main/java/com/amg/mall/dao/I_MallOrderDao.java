package com.amg.mall.dao;

import com.amg.mall.domain.MallOrder;
import com.amg.mall.domain.MallStockNumDTO;
import com.amg.mall.util.PageQueryUtil;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 商城订单dao接口
 */
@Repository
public interface I_MallOrderDao {
    
    /**
     * 获取订单总记录数
     * @param pageQueryUtil
     * @return
     */
    int getTotalMallOrders(PageQueryUtil pageQueryUtil);
    
    /**
     * 获取订单详细信息，
     * @param pageQueryUtil 是个Map集合
     * @return
     */
    List<MallOrder> findMallOrderList(PageQueryUtil pageQueryUtil);
	
    
	/**
	 * 保存订单
	 * @param mallOrder
	 * @return
	 */
	int insertSelective(MallOrder mallOrder);
	
	/**
	 * 根据订单编号查找订单
	 * @param orderNo
	 * @return
	 */
	MallOrder selectByOrderNo(@PathVariable("orderNo") String orderNo);
	
	/**
	 * 对订单数据进行更新
	 * @param mallOrder
	 * @return
	 */
	int updateMallOrderInfoByPrimaryKey(MallOrder mallOrder);
}
