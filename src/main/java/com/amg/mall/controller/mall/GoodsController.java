package com.amg.mall.controller.mall;

import com.amg.mall.common.Constants;
import com.amg.mall.controller.vo.MallGoodsDetailVO;
import com.amg.mall.domain.MallGoods;
import com.amg.mall.service.I_MallGoodsService;
import com.amg.mall.util.BeanUtil;
import com.amg.mall.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 商品控制器
 */
@Controller
public class GoodsController {
	
	@Autowired
	private I_MallGoodsService mallGoodsService;
	
	/**
	 * 商品详细信息入口方法
	 *
	 * @param goodsId
	 * @param request
	 * @return
	 */
	@GetMapping("/goods/detail/{goodsId}")
	public String detailPage(@PathVariable("goodsId") Long goodsId ,HttpServletRequest request) {
		
		
		if (goodsId < 1) {
			return "error/errorCauseService_5xx";
		}
		MallGoods goods = mallGoodsService.findGoodsDetailById(goodsId);
		System.out.println("goods = " + goods);
		if (goods == null) {
			return "error/errorCauseClient_404";
		}
		
		
		MallGoodsDetailVO mallGoodsDetailVO = new MallGoodsDetailVO();
		BeanUtil.copyProperties(goods ,mallGoodsDetailVO);
		mallGoodsDetailVO.setGoodsCarouselList(goods.getGoodsCarousel().split(","));
		request.setAttribute("goodsDetail" ,mallGoodsDetailVO);
		return "mall/goods_detail";
	}
	
	/**
	 * 商品搜索分页入口方法
	 * @param param
	 * @param session
	 * @param request
	 * @return
	 */
	@GetMapping({"/search" ,"/list.jsp"})
	public String searchListPage(@RequestParam Map<String, Object> param ,HttpSession session ,HttpServletRequest request) {
		
		if (StringUtils.isEmpty(param.get("page"))){
			param.put("page", 1);
		}
		param.put("limit",Constants.GOODS_SEARCH_PAGE_LIMIT);
		
		String keyword = "";
		//如果存在不为空的keyword字段，则可以进行下一步操作
		if (param.containsKey("keyword") && !StringUtils.isEmpty((param.get("keyword") +"").trim())) {
			keyword = param.get("keyword") + "";
		}
		request.setAttribute("keyword", keyword);
		param.put("keyword",keyword);
		PageQueryUtil pageQueryUtil = new PageQueryUtil(param);
		request.setAttribute("pageResult",mallGoodsService.searchGoods(pageQueryUtil));
		
		return "mall/list";
	}
}
