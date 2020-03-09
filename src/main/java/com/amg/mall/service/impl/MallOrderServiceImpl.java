package com.amg.mall.service.impl;

import com.amg.mall.common.*;
import com.amg.mall.controller.vo.*;
import com.amg.mall.dao.I_MallGoodsDao;
import com.amg.mall.dao.I_MallOrderDao;
import com.amg.mall.dao.I_MallOrderItemDao;
import com.amg.mall.dao.I_MallShoppingCartDao;
import com.amg.mall.domain.MallGoods;
import com.amg.mall.domain.MallOrder;
import com.amg.mall.domain.MallOrderItem;
import com.amg.mall.domain.MallStockNumDTO;
import com.amg.mall.service.I_MallOrderService;
import com.amg.mall.util.BeanUtil;
import com.amg.mall.util.NumberUtil;
import com.amg.mall.util.PageQueryUtil;
import com.amg.mall.util.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * 订单业务层实现类
 */
@Service
@Transactional
public class MallOrderServiceImpl implements I_MallOrderService {
	
	@Resource
	private I_MallOrderDao mallOrderDao;
	
	@Resource
	private I_MallOrderItemDao mallOrderItemDao;
	
	@Resource
	private I_MallShoppingCartDao mallShoppingCartDao;
	
	@Resource
	private I_MallGoodsDao mallGoodsDao;
	
	
	/**
	 * 我的订单
	 *
	 * @param pageQueryUtil
	 * @return
	 */
	@Override
	public PageResult getMyOrders(PageQueryUtil pageQueryUtil) throws ParseException {
		
		/**
		 * 在这里应该就是获取所有的参数
		 */
		
		//获取的总记录数是指在当前用户的情况下的所有订单数
		int total = mallOrderDao.getTotalMallOrders(pageQueryUtil);
		System.out.println("total = " + total);
		//获取订单的属性，记住pageQueryUtil其实是个Map集合，按照创建时间降序排列
		List<MallOrder> mallOrders = mallOrderDao.findMallOrderList(pageQueryUtil);
		System.out.println("mallOrders = " + mallOrders);
		List<MallOrderListVO> orderListVOS = new ArrayList<>();
		if (total > 0) {
			//数据转换，将实体类转换成vo
			orderListVOS = BeanUtil.copyList(mallOrders ,MallOrderListVO.class);
			System.out.println("orderListVOS = " + orderListVOS);
			//设置订单状态中文显示值
			for (MallOrderListVO orderListVO : orderListVOS) {
				
				//接收一个字符串，惯例做法是将状态封装在枚举类中，用的时候取出来
				orderListVO.setOrderStatusString(MallOrderStatusEnum.getMallOrderStatusEnumStatus(orderListVO.getOrder_status()).getName());
				//获取对应用户的所有的订单主键id值 stream是流概念 这里的map是A->B的意思，最终使用collect收集起来
				List<Integer> orderIds = mallOrders.stream().map(MallOrder::getOrder_id).collect(Collectors.toList());
				if (!CollectionUtils.isEmpty(orderIds)) {
					//传入的参数是一个List集合
					List<MallOrderItem> orderItems = mallOrderItemDao.findOrderByIds(orderIds);
					System.out.println("orderItems = " + orderItems);
					System.out.println(orderItems);
					Map<Integer, List<MallOrderItem>> itemByOrderIdMap = orderItems.stream().collect(groupingBy(MallOrderItem::getOrderId));
					for (MallOrderListVO mallOrderListVO : orderListVOS) {
						System.out.println("mallOrderListVO = " + mallOrderListVO.getOrder_id());
						//封装每个订单列表对象的订单项数据
						if (itemByOrderIdMap.containsKey(mallOrderListVO.getOrder_id())) {
							
							List<MallOrderItem> orderItemListTemp = itemByOrderIdMap.get(mallOrderListVO.getOrder_id());
							//将
							List<MallOrderItemVO> mallOrderItemVOS = BeanUtil.copyList(orderItemListTemp ,MallOrderItemVO.class);
							mallOrderListVO.setMallOrderItemVOS(mallOrderItemVOS);
							System.out.println(mallOrderListVO.getMallOrderItemVOS().toString());
						}
					}
				}
			}
			
		}
		System.out.println("orderListVOS = " + orderListVOS);
		
		PageResult pageResult = new PageResult(total ,
				pageQueryUtil.getCurrent_page() ,
				pageQueryUtil.getLimit() ,orderListVOS);
		return pageResult;
	}
	
	@Override
	public String saveOrder(MallUserVO user ,List<MallShoppingCartItemVO> chooseShoppingCartItem) throws Exception {
		
		//获取所有的购物车主键，返回的是一个List集合
		List<Long> shopCartItemIds = chooseShoppingCartItem.stream().map(MallShoppingCartItemVO::getCartItemId).collect(Collectors.toList());
		//获取所有的商品主键，返回的是一个List集合
		List<Long> goodsIds = chooseShoppingCartItem.stream().map(MallShoppingCartItemVO::getGoodsId).collect(Collectors.toList());
		//根据商品主键获取所有的商品信息
		List<MallGoods> mallGoodsList = mallGoodsDao.findGoodsByPrimaryKeys(goodsIds);
		
		//todo 测试理解这一段的用法
		/**
		 * Function是一个接口,Java 8 之后允许接口中存在具体方法，分别是default和static方法
		 * identity就是一个静态方法，它的作用是返回一个输出跟输入一样的lambda表达式对象
		 * （entire1,entire2) -> entire1的作用是如果发生冲突，保留现有条目，也就是entire1
		 *
		 * 下面例子mallGoodsMap中存放的key就是商品MallGoods中的主键id
		 */
		Map<Long, MallGoods> mallGoodsMap = mallGoodsList.stream().collect(Collectors.toMap(MallGoods::getGoodsId ,
				Function.identity() ,
				(entire1 ,entite2) -> entire1));
		for (Long aLong : mallGoodsMap.keySet()) {
			System.out.println("map中键为： " + aLong + " / 值为：" + mallGoodsMap.get(aLong));
		}
		
		//遍历List，对每一个MallShoppingCartItemVO对象进行具体的操作
		for (MallShoppingCartItemVO mallShoppingCartItemVO : chooseShoppingCartItem) {
			
			//这个mallShoppingCartItemVO对象就是提交订单中每一项商品，需要做点健壮性检验
			//如果在map中找不到对应mallShoppingCartItemVO对象里面的商品id值，则返回购物车错误信息
			if (!mallGoodsMap.containsKey(mallShoppingCartItemVO.getGoodsId())) {
				MallException.fail(ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult());
			}
			//如果购买的数量大于库存，当然也是行不通的
			if (mallShoppingCartItemVO.getGoodsCount() > mallGoodsMap.get(mallShoppingCartItemVO.getGoodsId()).getStockNum()) {
				MallException.fail(ServiceResultEnum.SHOPPING_ITEM_COUNT_ERROR.getResult());
			}
		}
		
		//删除购物车选中的商品项，逻辑就是当订单提交了之后，购物车中对应的商品需要被移出购物车，做法是将is_deleted属性标记改一下
		if (!CollectionUtils.isEmpty(shopCartItemIds) && !CollectionUtils.isEmpty(goodsIds) && !CollectionUtils.isEmpty(mallGoodsList)) {
			if (mallShoppingCartDao.deleteShopCartItemByPrimaryKeys(shopCartItemIds) > 0) {
				
				//还需要处理一下库存数量，
				List<MallStockNumDTO> stockNumDTOS = BeanUtil.copyList(chooseShoppingCartItem ,MallStockNumDTO.class);
				System.out.println("stockNumDTOS = " + stockNumDTOS);
				int updateResult = mallGoodsDao.updateStockNum(stockNumDTOS);
				if (updateResult < 1) {
					
					MallException.fail(ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult());
				}
				
				
				//生成订单号
				String orderNo = NumberUtil.genOrderNo();
				MallOrder mallOrder = new MallOrder();
				int totalPrice = 0;
				
				//保存订单
				//订单编号
				mallOrder.setOrder_number(orderNo);
				//用户id
				mallOrder.setUser_id(user.getUser_id());
				//用户地址
				mallOrder.setUser_address(user.getAddress());
				
				//计算总共应付价钱
				for (MallShoppingCartItemVO shoppingCartItemVO : chooseShoppingCartItem) {
					totalPrice += shoppingCartItemVO.getSellingPrice() * shoppingCartItemVO.getGoodsCount();
				}
				if (totalPrice < 1) {
					MallException.fail(ServiceResultEnum.ORDER_PRICE_ERROR.getResult());
				}
				mallOrder.setTotal_price(totalPrice);
				
				//生成订单项并保存订单项记录
				if (mallOrderDao.insertSelective(mallOrder) > 0) {
					
					//生成所有的订单快照
					List<MallOrderItem> mallOrderItems = new ArrayList<>();
					for (MallShoppingCartItemVO shoppingCartItemVO : chooseShoppingCartItem) {
						
						MallOrderItem mallOrderItem = new MallOrderItem();
						//使用BeanUtil工具类将newBeeMallShoppingCartItemVO中的属性复制到newBeeMallOrderItem对象中
						BeanUtil.copyProperties(shoppingCartItemVO ,mallOrderItem);
						//将订单主键id也给MallOrderItem，该PO对象就相当于数据库中的一张中间表
						//todo 获取不到订单主键id
						System.out.println("订单id：" + mallOrder.getOrder_id());
						mallOrderItem.setOrderId(mallOrder.getOrder_id());
						mallOrderItems.add(mallOrderItem);
					}
					
					//保存到数据库
					if (mallOrderItemDao.insertBatch(mallOrderItems) > 0) {
						
						//所有操作成功后，将订单号返回
						return orderNo;
					}
					return ServiceResultEnum.ORDER_CREATER_ERROR.getResult();
				}
				return ServiceResultEnum.DB_ERROR.getResult();
			}
			return ServiceResultEnum.DB_ERROR.getResult();
		}
		MallException.fail(ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult());
		return ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult();
	}
	
	
	
	@Override
	public MallOrderDetailVO getOrderDetailByOrderNo(String orderNo ,Integer user_id) {
		
		//根据订单编号得到具体是哪一张订单
		MallOrder mallOrder = mallOrderDao.selectByOrderNo(orderNo);
		
		//如果此订单不是属于该用户的
		if (!mallOrder.getUser_id().equals(user_id)) {
			return null;
		}
		if (mallOrder != null) {
			
			//从中间表中得到数据
			List<MallOrderItem> orderItems =  mallOrderItemDao.findOrderById(mallOrder.getOrder_id());
			
			
			if (!CollectionUtils.isEmpty(orderItems)) {
				
				//进行数据交换
				List<MallOrderItemVO> mallOrderItemVOS = BeanUtil.copyList(orderItems, MallOrderItemVO.class);
				MallOrderDetailVO orderDetailVO = new MallOrderDetailVO();
				BeanUtil.copyProperties(mallOrder, orderDetailVO);
				
				//将订单状态设置成中文显示格式
				orderDetailVO.setOrderStatusString(MallOrderStatusEnum.getMallOrderStatusEnumStatus(orderDetailVO.getOrder_status()).getName());
				//将支付状态设置成中文显示格式
				orderDetailVO.setPayStatusString(MallPayStatusEnum.getPayStatusString(orderDetailVO.getPay_status()).getName());
				//将支付方式设置成中文显示格式
				orderDetailVO.setPayTypeString(MallPayTypeEnum.getPayTypeString(orderDetailVO.getPay_type()).getName());
				//把MallOrderItemVO对象设置进去
				orderDetailVO.setMallOrderItemVOS(mallOrderItemVOS);
				
				return orderDetailVO;
			}
		}
		
		return null;
	}
	
	/**
	 * 返回账户信息
	 * @param orderNo
	 * @return
	 */
	@Override
	public MallOrder getMallOrderByOrderNo(String orderNo) {
		return mallOrderDao.selectByOrderNo(orderNo);
	}
	
	@Override
	public String orderPaySuccess(String orderNo ,int payType) {
		
		MallOrder mallOrder = mallOrderDao.selectByOrderNo(orderNo);
		
		if (mallOrder != null){
			
			//设置支付类型
			mallOrder.setPay_type((byte) payType);
			//设置支付状态
			mallOrder.setPay_status((byte) MallPayStatusEnum.PAID.getPay_status());
			//设置支付时间
			mallOrder.setPay_time(new Date());
			//设置订单状态
			mallOrder.setOrder_status((byte) MallOrderStatusEnum.ORDER_ALREADY_PAY.getOrderStatus());
			//设置更新时间
			mallOrder.setUpdate_time(new Date());
			
			//然后对数据库中的数据进行更新
			if (mallOrderDao.updateMallOrderInfoByPrimaryKey(mallOrder) > 0){
				return ServiceResultEnum.SUCCESS.getResult();
			} else {
				return ServiceResultEnum.DB_ERROR.getResult();
			}
		}
		return ServiceResultEnum.ORDER_NOT_EXIST_ERROR.getResult();
	}
}
