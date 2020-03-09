package com.amg.mall.controller.mall;

import com.amg.mall.common.Constants;
import com.amg.mall.common.ServiceResultEnum;
import com.amg.mall.controller.vo.MallShoppingCartItemVO;
import com.amg.mall.controller.vo.MallUserVO;
import com.amg.mall.domain.MallShoppingCart;
import com.amg.mall.domain.MallUser;
import com.amg.mall.service.I_MallShoppingCartService;
import com.amg.mall.util.Result;
import com.amg.mall.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 购物车控制器
 */
@Controller
public class ShoppingCartController {
	
	@Autowired
	private I_MallShoppingCartService mallShoppingCartService;
	
	@GetMapping("/shop-cart")
	public String cartListPage(HttpServletRequest request ,HttpSession session) {
		
		//获取用户id
		MallUserVO user = (MallUserVO) session.getAttribute(Constants.Mall_User_SESSION_KEY);
		int itemTotal = 0;
		int priceTotal = 0;
		List<MallShoppingCartItemVO> myShoppingCartItems = mallShoppingCartService.getMyShoppingCartItems(user.getUser_id());
		System.out.println("myShoppingCartItems = " + myShoppingCartItems);
		if (!CollectionUtils.isEmpty(myShoppingCartItems)) {
			
			//计算购物车中总共购买的商品数量
			itemTotal = myShoppingCartItems.stream().mapToInt(MallShoppingCartItemVO::getGoodsCount).sum();
			
			if (itemTotal < 1) {
				return "error/errorCauseService_5xx";
			}
			
			//计算总价
			for (MallShoppingCartItemVO myShoppingCartItem : myShoppingCartItems) {
				
				priceTotal += myShoppingCartItem.getSellingPrice() * myShoppingCartItem.getGoodsCount();
				
				if (priceTotal < 1) {
					return "error/errorCauseService_5xx";
				}
			}
		}
		request.setAttribute("itemTotal" ,itemTotal);
		request.setAttribute("priceTotal" ,priceTotal);
		request.setAttribute("shopCartResult" ,myShoppingCartItems);
		return "mall/shop_cart";
	}
	
	@PostMapping("/shop-cart")
	@ResponseBody
	public Result saveGoodsToShoppingCart(@RequestBody MallShoppingCart mallShoppingCart ,
										  HttpSession session) {
		MallUserVO user = (MallUserVO) session.getAttribute(Constants.Mall_User_SESSION_KEY);
		mallShoppingCart.setUserId(user.getUser_id());
		
		String saveResult = mallShoppingCartService.saveMallCartItem(mallShoppingCart);
		//添加成功
		if (ServiceResultEnum.SUCCESS.getResult().equals(saveResult)) {
			return ResultGenerator.getSuccessResult();
		}
		//添加失败
		return ResultGenerator.getFailResult(saveResult);
	}
	
	@PutMapping("/shop-cart")
	@ResponseBody
	public Result updateShoppingCartItems(@RequestBody MallShoppingCart mallShoppingCart ,
										  HttpSession session) {
		
		/**
		 * 更新购物车商品信息
		 */
		
		MallUserVO user = (MallUserVO) session.getAttribute(Constants.Mall_User_SESSION_KEY);
		if (user == null) {
			return ResultGenerator.getFailResult("找不到用户");
		}
		mallShoppingCart.setUserId(user.getUser_id());
		String updateResult = mallShoppingCartService.updateShopCartItem(mallShoppingCart);
		
		//更新成功
		if (ServiceResultEnum.SUCCESS.getResult().equals(updateResult)) {
			return ResultGenerator.getSuccessResult();
		}
		
		return ResultGenerator.getFailResult(updateResult);
	}
	
	@DeleteMapping("/shop-cart/{MallShopCartItemId}")
	@ResponseBody
	public Result deleteShoppingCartItem(@PathVariable("MallShopCartItemId") Long mallShoppingCartItemId){
		
		boolean deleteResult = mallShoppingCartService.deleteShopCartItemById(mallShoppingCartItemId);
		
		//删除成功,不需要返回信息，所以使用布尔类型即可
		if (deleteResult == true ){
			return ResultGenerator.getSuccessResult();
		}
		
		//操作失败
		return ResultGenerator.getFailResult(ServiceResultEnum.OPERATE_ERROR.getResult());
		
		
	}
	
	/**
	 * 给钱了喂！
	 * @return
	 */
	@GetMapping("/shop-cart/settle")
	public String payMoneyPage(@RequestParam("cartItemId") Long ids[],
							   HttpSession session,
							   HttpServletRequest request,
							   HttpServletResponse response) throws ServletException, IOException {
		int totalMoney = 0;
		
		//ids是获取购物车对应商品项的主键，确认是可以获取成功的,放入session中，供后续使用
		session.setAttribute("cartItemId", ids);
		//确认用户
		MallUserVO user = (MallUserVO) session.getAttribute(Constants.Mall_User_SESSION_KEY);
		
		List<MallShoppingCartItemVO> mallShoppingCartItemVOS = mallShoppingCartService.getChooseShoppingCartItem(ids,user.getUser_id());
		
		if (CollectionUtils.isEmpty(mallShoppingCartItemVOS)){
			
			//如果没有数据，则原地不动，留在购物车中
			return "/shop-cart";
		}
		
		for (MallShoppingCartItemVO mallShoppingCartItemVO : mallShoppingCartItemVOS) {
			totalMoney += mallShoppingCartItemVO.getGoodsCount()* mallShoppingCartItemVO.getSellingPrice();
		}
		if (totalMoney < 1){
			return "error/errorCauseService_5xx";
		}
		request.setAttribute("payMoney", totalMoney);
		request.setAttribute("myShoppingCartItems",mallShoppingCartItemVOS);
		
		System.out.println("mallShoppingCartItemVOS = " + mallShoppingCartItemVOS);
		return "mall/order-settle";
		
	}
}
