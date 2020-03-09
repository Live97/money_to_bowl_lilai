package com.amg.mall.service;

import com.amg.mall.controller.vo.MallOrderDetailVO;
import com.amg.mall.controller.vo.MallShoppingCartItemVO;
import com.amg.mall.controller.vo.MallUserVO;
import com.amg.mall.domain.MallOrder;
import com.amg.mall.util.PageQueryUtil;
import com.amg.mall.util.PageResult;

import java.text.ParseException;
import java.util.List;

/**
 * 订单业务层接口
 */
public interface I_MallOrderService {
    
    
    PageResult getMyOrders(PageQueryUtil pageQueryUtil) throws ParseException;
	
	String saveOrder(MallUserVO user ,List<MallShoppingCartItemVO> chooseShoppingCartItem) throws Exception;
	
	MallOrderDetailVO getOrderDetailByOrderNo(String orderNo ,Integer user_id);
	
	MallOrder getMallOrderByOrderNo(String orderNo);
	
	String orderPaySuccess(String orderNo ,int payType);
}
