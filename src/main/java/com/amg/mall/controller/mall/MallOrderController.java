package com.amg.mall.controller.mall;

import com.amg.mall.common.Constants;
import com.amg.mall.common.MallException;
import com.amg.mall.common.ServiceResultEnum;
import com.amg.mall.controller.vo.MallOrderDetailVO;
import com.amg.mall.controller.vo.MallOrderItemVO;
import com.amg.mall.controller.vo.MallShoppingCartItemVO;
import com.amg.mall.controller.vo.MallUserVO;
import com.amg.mall.domain.MallOrder;
import com.amg.mall.domain.MallUser;
import com.amg.mall.service.I_MallOrderService;
import com.amg.mall.service.I_MallShoppingCartService;
import com.amg.mall.service.impl.MallOrderServiceImpl;
import com.amg.mall.util.PageQueryUtil;
import com.amg.mall.util.Result;
import com.amg.mall.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 订单控制器
 */
@Controller
public class MallOrderController {
    
    @Autowired
    private I_MallOrderService mallOrderService;
    
    @Autowired
    private I_MallShoppingCartService mallShoppingCartService;
    
    /**
     * 商城用户订单列表
     * @param params
     * @param session
     * @param request
     * @return
     */
    @GetMapping("/order")
    public String orderListPage(@RequestParam Map<String,Object> params,HttpSession session,HttpServletRequest request) throws ParseException {
    
        //首先还是获取到到底是哪一位用户的订单列表
        MallUserVO user = (MallUserVO) session.getAttribute(Constants.Mall_User_SESSION_KEY);
        
        //将用户及相关信息存入到map集合里面
        params.put("user_id", user.getUser_id());
        if (StringUtils.isEmpty(params.get("page"))){
            params.put("page", 1);
        }
        params.put("limit",Constants.ORDER_SEARCH_PAGE_LIMIT);
        PageQueryUtil pageQueryUtil = new PageQueryUtil(params);
        request.setAttribute("orderPageResult",mallOrderService.getMyOrders(pageQueryUtil));
        request.setAttribute("path", "order");
        
        return "mall/my-orders";
    }
    @GetMapping("/saveOrder")
    public String saveOrder(HttpSession session) throws Exception {
    
        //获取用户
        MallUserVO user = (MallUserVO) session.getAttribute(Constants.Mall_User_SESSION_KEY);
        
        //获取结算订单的主键
        Long[] cartItem = (Long[]) session.getAttribute("cartItemId");
        List<MallShoppingCartItemVO> chooseShoppingCartItem = mallShoppingCartService.getChooseShoppingCartItem(cartItem ,user.getUser_id());
        
        if (StringUtils.isEmpty(user.getAddress().trim())){
            //无收货地址
            MallException.fail(ServiceResultEnum.NULL_ADDRESS_ERROR.getResult());
        }
        if (CollectionUtils.isEmpty(chooseShoppingCartItem)){
            //集合为空
            MallException.fail(ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult());
        }
        
        //保存订单并返回订单编号
        String saveOrderResult = mallOrderService.saveOrder(user,chooseShoppingCartItem);
    
        return "redirect:/order/" + saveOrderResult;
    }
    @GetMapping("/order/{orderNo}")
    public String orderDetailPage(@PathVariable("orderNo") String orderNo,HttpServletRequest request,HttpSession session){
    
        MallUserVO user = (MallUserVO) session.getAttribute(Constants.Mall_User_SESSION_KEY);
        
        //根据订单编号以及用户id查找所有的订单
        MallOrderDetailVO result = mallOrderService.getOrderDetailByOrderNo(orderNo,user.getUser_id());
        System.out.println("result = " + result);
        if (result == null){
            return "error/errorCauseService_5xx";
        }
        request.setAttribute("orderDetail", result);
        
        return "mall/order_detail";
    }
    
    @GetMapping("selectPayType")
    public String selectPayType(@RequestParam("orderNo") String orderNo,HttpSession session,HttpServletRequest request){
        
        MallUserVO user = (MallUserVO) session.getAttribute(Constants.Mall_User_SESSION_KEY);
        MallOrder Mallorder = mallOrderService.getMallOrderByOrderNo(orderNo);
        
        if (Mallorder == null){
            return ServiceResultEnum.ORDER_NOT_EXIST_ERROR.getResult();
        }
        if (!user.getUser_id().equals(Mallorder.getUser_id())){
            return ServiceResultEnum.ERROR.getResult();
        }
        
        request.setAttribute("orderNo", orderNo);
        request.setAttribute("totalPrice", Mallorder.getTotal_price());
        //跳转到选择支付方式页面
        return "mall/pay-select";
    }
    @GetMapping("payPage")
    public String payMoneyPage(@RequestParam("orderNo") String orderNo,
                               @RequestParam("payType") int payType,
                               HttpSession session,
                               HttpServletRequest request){
    
        MallUserVO user = (MallUserVO) session.getAttribute(Constants.Mall_User_SESSION_KEY);
        MallOrder MallOrder = mallOrderService.getMallOrderByOrderNo(orderNo);
        
        request.setAttribute("orderNo", orderNo);
        request.setAttribute("totalPrice", MallOrder.getTotal_price());
        
        if (payType == 1){
            return "mall/alipay";
        } else {
            return "mall/wxpay";
        }
    }
    
    @GetMapping("paySuccess")
    @ResponseBody
    public Result paySuccess(@RequestParam("orderNo") String orderNo,
                             @RequestParam("payType") int payType,
                             HttpSession session){
    
        MallUserVO user = (MallUserVO) session.getAttribute(Constants.Mall_User_SESSION_KEY);
        /**
         * 修改订单信息
         */
        String orderResult = mallOrderService.orderPaySuccess(orderNo,payType);
        
        if (ServiceResultEnum.SUCCESS.getResult().equals(orderResult)){
            return ResultGenerator.getSuccessResult();
        }
        return ResultGenerator.getFailResult(orderResult);
    }
}