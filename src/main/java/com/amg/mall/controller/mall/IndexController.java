package com.amg.mall.controller.mall;

import com.amg.mall.common.Constants;
import com.amg.mall.common.IndexConfigTypEnum;
import com.amg.mall.controller.vo.MallIndexCarouselVO;
import com.amg.mall.controller.vo.MallIndexConfigGoodsVO;
import com.amg.mall.service.I_MallIndexCarouselService;
import com.amg.mall.service.I_MallIndexConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 商城主页控制器
 */
@Controller
public class IndexController {
    
    @Autowired
    private I_MallIndexConfigService mallIndexConfigService;
    
    @Autowired
    private I_MallIndexCarouselService mallIndexCarouselService;
    
    @GetMapping({"/index","/","/index.jsp"})
    public String indexPage(HttpServletRequest request) {
    
        //轮播图 数量5
        List<MallIndexCarouselVO> carousel = mallIndexCarouselService.getCarouselForIndex(
                Constants.INDEX_CAROUSEL_NUMBER
        );
    
        System.out.println("carousel = " + carousel);
        //热销商品 数量4
        List<MallIndexConfigGoodsVO> hotGoodses = mallIndexConfigService.getConfigGoodsForIndex(
                IndexConfigTypEnum.INDEX_GOODS_HOT.getType(),
                Constants.INDEX_GOODS_HOT_NUMBER);
        System.out.println("hotGoodses = " + hotGoodses);
        //新品 数量5
        List<MallIndexConfigGoodsVO> newGoodses = mallIndexConfigService.getConfigGoodsForIndex(
                IndexConfigTypEnum.INDEX_GOODS_NEW.getType(),
                Constants.INDEX_GOODS_NEW_NUMBER
        );
        System.out.println("newGoodses = " + newGoodses);
        //推荐商品 数量10
        List<MallIndexConfigGoodsVO> recommondGoodses = mallIndexConfigService.getConfigGoodsForIndex(
                IndexConfigTypEnum.INDEX_GOODS_RECOMMOND.getType(),
                Constants.INDEX_GOODS_RECOMMOND_NUMBER
        );
        System.out.println("recommondGoodses = " + recommondGoodses);
        
        //查询出来还要存储到session中，前台页面可以直接
        request.setAttribute("carousel", carousel);
        request.setAttribute("hotGoodses", hotGoodses);
        request.setAttribute("newGoodses",newGoodses);
        request.setAttribute("recommondGoodses", recommondGoodses);
        return "mall/index";
    }
}
