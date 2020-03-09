package com.amg.mall.service;

import com.amg.mall.controller.vo.MallShoppingCartItemVO;
import com.amg.mall.domain.MallShoppingCart;

import java.util.List;

public interface I_MallShoppingCartService {
	
	/**
	 * 获取所有的商品项
	 * @param user_id
	 * @return
	 */
	List<MallShoppingCartItemVO> getMyShoppingCartItems(Integer user_id);
	
	
	/**
	 * 将商品添加到购物车，即执行插入操作
	 * @param mallShoppingCart
	 * @return
	 */
	String saveMallCartItem(MallShoppingCart mallShoppingCart);
	
	
	/**
	 * 更新购物车商品信息
	 * @param mallShoppingCart
	 * @return
	 */
	String updateShopCartItem(MallShoppingCart mallShoppingCart);
	
	Boolean deleteShopCartItemById(Long mallShoppingCartItemId);
	
	/**
	 * 获取选择到的商品，进行下一步操作
	 * @param ids
	 * @param user_id
	 * @return
	 */
	List<MallShoppingCartItemVO> getChooseShoppingCartItem(Long[] ids ,Integer user_id);
}
