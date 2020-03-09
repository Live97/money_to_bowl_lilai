package com.amg.mall.dao;

import com.amg.mall.domain.MallShoppingCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 购物车dao层接口
 */
public interface I_MallShoppingCartDao {
	
	/**
	 * 根据用户id查询所有属于该用户的购物商品
	 * @param user_id
	 * @return
	 */
	List<MallShoppingCart> findShoppingCartByUserId(@Param("user_id") Integer user_id,@Param("number") Integer number);
	
	/**
	 * 根据用户id以及商品id查询购物车是是否已经存在同样的商品项
	 * @param goodsId
	 * @param userId
	 * @return
	 */
	MallShoppingCart findShopCartByGoodsIdAndUserId(@Param("goodsId") Long goodsId ,@Param("userId") Integer userId);
	
	/**
	 * 查询单个商品的数量
	 * @param userId
	 * @return
	 */
	int findCountByUserId(@Param("userId") Integer userId);
	
	/**
	 * 执行添加到购物车逻辑操作，dao中就是插入数据库
	 * @param mallShoppingCart
	 * @return
	 */
	int saveGoodsToShopCart(MallShoppingCart mallShoppingCart);
	
	/**
	 * 根据购物车主键查询值
	 * @param cartItemId
	 * @return
	 */
	MallShoppingCart findShopCartByPrimaryKey(Long cartItemId);
	
	/**
	 * 执行更新操作
	 * @param mallShoppingCartUpdate
	 * @return
	 */
	int updateByPrimaryKey(MallShoppingCart mallShoppingCartUpdate);
	
	/**
	 * 删除购物车中的商品项
	 * @param mallShoppingCartItemId
	 * @return
	 */
	int deleteShopCartItemByPrimaryKey(@Param("mallShoppingCartItemId") Long mallShoppingCartItemId);
	
	/**
	 * 根据主键id和用户id查询选择到的商品项
	 * @param id
	 * @param user_id
	 * @return
	 */
	MallShoppingCart findShopCartByPrimaryKeyAndUserId(@Param("shopCartId") Long id ,@Param("userId") Integer user_id);
	
	/**
	 * 根据id批量删除
	 * @param shopCartItemIds
	 * @return
	 */
	int deleteShopCartItemByPrimaryKeys(List<Long> shopCartItemIds);
}
