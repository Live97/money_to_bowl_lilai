package com.amg.mall.service.impl;

import com.amg.mall.common.Constants;
import com.amg.mall.common.ServiceResultEnum;
import com.amg.mall.controller.vo.MallShoppingCartItemVO;
import com.amg.mall.dao.I_MallGoodsDao;
import com.amg.mall.dao.I_MallShoppingCartDao;
import com.amg.mall.domain.MallGoods;
import com.amg.mall.domain.MallShoppingCart;
import com.amg.mall.service.I_MallShoppingCartService;
import com.amg.mall.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("all")
@Service
public class MallShoppingCartServiceImpl implements I_MallShoppingCartService {
	
	@Autowired
	private I_MallShoppingCartDao mallShoppingCartDao;
	
	@Autowired
	private I_MallGoodsDao mallGoodsDao;
	
	/**
	 * 获取用户购物车页面信息
	 * @param user_id
	 * @return
	 */
	@Override
	public List<MallShoppingCartItemVO> getMyShoppingCartItems(Integer user_id) {
		
		//最终返回的list集合
		List<MallShoppingCartItemVO> mallShoppingCartItemVOS = new ArrayList<>();
		//当前用户的购物车内容
		List<MallShoppingCart> shoppingCartItems = mallShoppingCartDao.findShoppingCartByUserId(
				user_id,
				Constants.SHOPPING_CART_ITEM_LIMIT_NUMBER);
		
		if (!CollectionUtils.isEmpty(shoppingCartItems)) {
			
			//使用Java8新特性，获取其中的商品id
			List<Long> goodsIds = shoppingCartItems.stream().map(MallShoppingCart::getGoodsId).collect(Collectors.toList());
			
			//获取到所有的商品信息
			List<MallGoods> mallGoods = mallGoodsDao.findGoodsByPrimaryKeys(goodsIds);
			Map<Long,MallGoods> mallGoodsMap = new HashMap<>();
			
			//todo 去理解这段代码在做什么？？？
			if (!CollectionUtils.isEmpty(mallGoods)){
				mallGoodsMap = mallGoods.stream().collect(
						Collectors.toMap(MallGoods::getGoodsId,Function.identity(),
								(entity1,entity2) -> entity1));
			}
			//遍历购物车
			for (MallShoppingCart shoppingCartItem : shoppingCartItems) {
				MallShoppingCartItemVO mallShoppingCartItemVO = new MallShoppingCartItemVO();
				//param1: source ||||   param2:target 将shopCart实体类中的数据传给VO对象
				BeanUtil.copyProperties(shoppingCartItem, mallShoppingCartItemVO);
				
				//不过VO对象中还差几样数据 ，所以需要额外为他们添加进去
				if (mallGoodsMap.containsKey(shoppingCartItem.getGoodsId())){
					
					//根据商品id获取到对应的商品
					MallGoods mallGoodsTemp = mallGoodsMap.get(shoppingCartItem.getGoodsId());
					mallShoppingCartItemVO.setGoodsCoverImg(mallGoodsTemp.getGoodsCoverImg());
					
					//商品名过长，cut一下
					String goodsName = mallGoodsTemp.getGoodsName();
					if (goodsName.length() > 23){
						goodsName = goodsName.substring(0, 23)+"...";
					}
					mallShoppingCartItemVO.setGoodsName(goodsName);
					mallShoppingCartItemVO.setSellingPrice(mallGoodsTemp.getSellingPrice());
					mallShoppingCartItemVOS.add(mallShoppingCartItemVO);
				}
				
			}
			
		}
		return mallShoppingCartItemVOS;
	}
	
	/**
	 * 执行保存商品操作业务
	 * @param mallShoppingCart
	 * @return
	 */
	@Override
	public String saveMallCartItem(MallShoppingCart mallShoppingCart) {
		
		//根据商品id和用户id查询购物车中有没有已经存在的数据
		
		MallShoppingCart temp = mallShoppingCartDao.findShopCartByGoodsIdAndUserId(
				mallShoppingCart.getGoodsId(),
				mallShoppingCart.getUserId());
		
		if (temp != null){
			//说明该商品已经存在于购物车中，需要修改的只有数量了
			temp.setGoodsCount(mallShoppingCart.getGoodsCount());
			return updateShopCartItem(temp);
		}
		
		//当商品为空的时候,返回商品不存在错误信息
		MallGoods goods = mallGoodsDao.findGoodsByPrimaryKey(mallShoppingCart.getGoodsId());
		if (goods == null){
			return ServiceResultEnum.GOODS_NOT_EXIST.getResult();
		}
		
		//超出购物车能容纳的商品数,依然是返回错误信息
		int totalItem = mallShoppingCartDao.findCountByUserId(mallShoppingCart.getUserId());
		System.out.println("totalItem = " + totalItem);
		if (totalItem >= Constants.SHOPPING_CART_ITEM_LIMIT_NUMBER){
			return ServiceResultEnum.SHOPPING_CART_ITEM_OUT_OF_TOTAL_NUMBER_ERROR.getResult();
		}
		
		//保存成功
		if (mallShoppingCartDao.saveGoodsToShopCart(mallShoppingCart) > 0) {
			return ServiceResultEnum.SUCCESS.getResult();
		}
		return ServiceResultEnum.DB_ERROR.getResult();
	}
	
	/**
	 * 更新购物车商品信息
	 * @param mallShoppingCart
	 * @return
	 */
	@Override
	public String updateShopCartItem(MallShoppingCart mallShoppingCart) {
		
		//能进入该方法，代表记录已经存在于购物车中的，所以通过主键去查找这条记录，再进行对应修改即可
		MallShoppingCart mallShoppingCartUpdate = mallShoppingCartDao.findShopCartByPrimaryKey(
				mallShoppingCart.getCartItemId());
		
		//订单是否存在
		if (mallShoppingCartUpdate == null) {
			return ServiceResultEnum.DATA_NOT_EXIST.getResult();
		}
		
		//判断购物车单件商品是否超出限制范围
		if (mallShoppingCart.getGoodsCount() > Constants.SHOPPING_CART_ITEM_LIMIT_NUMBER) {
			return ServiceResultEnum.SHOPPING_CART_ITEM_OUT_OF_LIMIT_NUMBER_ERROR.getResult();
		}
		
		//更新对应的信息
		mallShoppingCartUpdate.setGoodsCount(mallShoppingCart.getGoodsCount());
		
		//执行更新操作
		if (mallShoppingCartDao.updateByPrimaryKey(mallShoppingCartUpdate) > 0) {
			return ServiceResultEnum.SUCCESS.getResult();
		}
		
		return ServiceResultEnum.DB_ERROR.getResult();
	}
	
	/**
	 * 删除购物车中商品项业务操作
	 * @param mallShoppingCartItemId
	 * @return
	 */
	@Override
	public Boolean deleteShopCartItemById(Long mallShoppingCartItemId) {
		
		return mallShoppingCartDao.deleteShopCartItemByPrimaryKey(mallShoppingCartItemId) > 0;
	}
	
	/**
	 * 根据购物车项id和用户id标识购物车商品
	 * @param ids
	 * @param user_id
	 * @return
	 */
	@Override
	public List<MallShoppingCartItemVO> getChooseShoppingCartItem(Long[] ids ,Integer user_id) {
		
		//最终返回的列表，里面存放的是多个VO对象，VO对象里存放的都是结算业务需要的属性，供前端调用显示
		List<MallShoppingCartItemVO> mallShoppingCartItemVOS = new ArrayList<>();
		List<MallShoppingCart> mallShoppingCarts = new ArrayList<>();
		for (Long id : ids) {
			//购物车项目
			MallShoppingCart temp = mallShoppingCartDao.findShopCartByPrimaryKeyAndUserId(id,user_id);
			mallShoppingCarts.add(temp);
		}
		
		if (!CollectionUtils.isEmpty(mallShoppingCarts)){
			
			/**
			 * 从集合中获取所有对象的商品id
			 */
			List<Long> goodsId = mallShoppingCarts.stream().map(mallShoppingCart -> mallShoppingCart.getGoodsId()).collect(Collectors.toList());
			
			//然后根据商品id查找所有的商品信息
			List<MallGoods> mallGoods = mallGoodsDao.findGoodsByPrimaryKeys(goodsId);
			
			
			//todo 继续去一下这段代码的用法，以及这里为什么需要一个map集合？
			Map<Long,MallGoods> mallGoodsMap = new HashMap<>();
			if (!CollectionUtils.isEmpty(mallGoods)){
				
				//已知的是，这会把商品id传给map
				mallGoodsMap = mallGoods.stream().collect(Collectors.toMap(MallGoods::getGoodsId ,Function.identity() ,
						(entite1 ,entite2) -> entite1));
			}
			for (MallShoppingCart mallShoppingCart : mallShoppingCarts) {
				
				//创建VO对象，将实体类对象数据传入VO对象中
				MallShoppingCartItemVO mallShoppingCartItemVO = new MallShoppingCartItemVO();
				BeanUtil.copyProperties(mallShoppingCart, mallShoppingCartItemVO );
				
				if (mallGoodsMap.containsKey(mallShoppingCart.getGoodsId())){
					
					//最终得到一个临时的商品实体类对象
					MallGoods goodsTemp = mallGoodsMap.get(mallShoppingCart.getGoodsId());
					
					//为VO对象里面的属性赋值，结算业务需要用到的属性
					mallShoppingCartItemVO.setGoodsCoverImg(goodsTemp.getGoodsCoverImg());
					String goodsName = goodsTemp.getGoodsName();
					
					if (goodsName.length() > 28){
						goodsName = goodsName.substring(0, 28)+"...";
					}
					mallShoppingCartItemVO.setGoodsName(goodsName);
					mallShoppingCartItemVO.setSellingPrice(goodsTemp.getSellingPrice());
					mallShoppingCartItemVOS.add(mallShoppingCartItemVO);
					
				}
			}
		}
		return mallShoppingCartItemVOS;
	}
}
