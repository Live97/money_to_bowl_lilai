<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>钱到碗里来商城</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" type="text/css" href="/css/swiper.min.css">
    </head>
    <body>
        <!-- start header -->
        <header>
            <div class="top center">
                <div class="left fl">
                    <ul>
                        <li><a href="/index" target="_self">钱到碗里来商城</a></li>
                        <li>|</li>
                        <li><a href="##">后台管理系统</a></li>
                        <li>|</li>
                        <li><a href="#3">快到碗里来</a></li>
                        <li>|</li>
                        <li><a href="##">你才到碗里去</a></li>
                        <li>|</li>
                        <li><a href="##">商城介绍</a></li>
                        <li>|</li>
                        <li><a href="##">凑个数2</a></li>
                        <li>|</li>
                        <li><a href="##">凑个数3</a></li>
                        <li>|</li>
                        <li><a href="##">问题反馈</a></li>
                        <li>|</li>
                        <li><a href="##">Select Region</a></li>
                        <div class="clear"></div>
                    </ul>
                </div>
                <div class="right fr">
                    
                    <c:if test="${MallUser == null}">
                        <div class="gouwuche fr"><a href="##">购物车(0)</a></div>
                    </c:if>
                    <c:if test="${MallUser != null}">
                        <div class="gouwuche fr"><a href="/shop-cart">购物车(${MallUser.shop_cart_item_number})</a></div>
                    </c:if>
                    <div class="fr">
                        <%-- 当session还没有用户信息时，显示的效果--%>
                        <c:if test="${MallUser == null}">
                            <ul class="user_no">
                                <li><a href="/login" target="_parent">登录 | </a></li>
                                <li><a href="./register" target="_parent">注册</a></li>
                            </ul>
                        </c:if>
                        <%-- 有用户登录之后显示的效果--%>
                        <c:if test="${MallUser != null}">
                            <div class="user">
                                <div class="selector">
                                    <ul>
                                        <li><a href="/personal">个人中心</a></li>
                                        <li><a href="/order">我的订单</a></li>
                                        <li><a href="/logout">退出登录</a></li>
                                    </ul>
                                </div>
                                <a href="#" class="username">${MallUser.user_nick_name}</a>
                            </div>
                        
                        </c:if>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
            </div>
        </header>
        <!--end header -->
        
        <!-- start banner_x -->
        <div class="banner_x center">
            <a href="/index" target="_blank">
                <div class="money_logo fl"><img src="/image/others/logo2.jpg" ></div>
            </a>
            <a href="">
                <div class="ad_top fl"></div>
            </a>
            <div class="nav_top fl">
                <ul>
                    <li><a href="/index" target="_blank">手机</a></li>
                    <li><a href="##">耳机</a></li>
                    <li><a href="##">电脑</a></li>
                    <li><a href="##">电视</a></li>
                    <li><a href="##">盒子·影音</a></li>
                    <li><a href="##">路由器</a></li>
                    <li><a href="##">智能硬件</a></li>
                    <li><a href="##">服务</a></li>
                    <li><a href="##">社区</a></li>
                </ul>
            </div>
            <div class="search fr">
                    <div class="text fl">
                        <input type="text" id="keyword"  class="shuru" placeholder="小米6&nbsp;小米MIX现货">
                    </div>
                    <div class="submit fl">
                        <input type="submit"  id="btn-search" name="btn-search" class="sousuo" value="搜索" onclick="search();" />
                    </div>
                    <div class="clear"></div>
                <div class="clear"></div>
            </div>
        </div>
        <!-- end banner_x -->
        
        <!-- start banner_y -->
        <div class="banner_y center">
            
            <div class="nav fl">
                <ul>
                    <li>
                        <a href="">手机</a>
                        <a href="">电话卡</a>
                    </li>
                    <li>
                        <a href="">笔记本</a>
                        <a href="">平板</a>
                    </li>
                    <li>
                        <a href="">电视</a>
                        <a href="">盒子</a>
                    </li>
                    <li>
                        <a href="">路由器</a>
                        <a href="">智能硬件</a>
                    </li>
                    <li>
                        <a href="">移动电源</a>
                        <a href="">电池</a>
                        <a href="">插线板</a>
                    </li>
                    <li>
                        <a href="">耳机</a>
                        <a href="">音箱</a>
                    </li>
                    <li>
                        <a href="">保护套</a>
                        <a href="">贴膜</a>
                    </li>
                    <li>
                        <a href="">线材</a>
                        <a href="">支架</a>
                        <a href="">储存卡</a>
                    </li>
                    <li>
                        <a href="">箱包</a>
                        <a href="">服饰</a>
                        <a href="">鞋</a>
                        <a href="">眼镜</a>
                    </li>
                    <li>
                        <a href="">米兔</a>
                        <a href="">生活周边</a>
                    </li>
                </ul>
            </div>
    
            <div class="swiper-container fl" style="width: 996px;height: 100%;">
    
                <!-- 当没有配置轮播图的时候，默认使用这几张 -->
                <c:if test="${empty carousel}">
                    <div class="swiper-wrapper carousel-style">
                        <div class="swiper-slide carousel-style"><img src="/image/banner2.jpg"></div>
                        <div class="swiper-slide"><img src="/image/others/swiper/banner04.jpg" ></div>
                        <div class="swiper-slide"><img src="/image/others/swiper/banner01.jpg"></div>
                        <div class="swiper-slide"><img src="/image/others/swiper/banner02.jpg"></div>
                        <div class="swiper-slide"><img src="/image/others/swiper/banner03.jpg"></div>
                    </div>
                </c:if>
                
                <!-- 当配置了轮播图的时候 -->
                <c:if test="${not empty carousel}">
                    <c:forEach items="${carousel}" var="item" varStatus="s">
                        <div class="swiper-wrapper carousel-style">
                            <div class="swiper-slide carousel-style"><img src="${item.carouselUrl}"></div>
                        </div>
                    </c:forEach>
                </c:if>
                <div class="swiper-pagination"></div>
                <div class="swiper-button-prev"></div>
                <div class="swiper-button-next"></div>
            </div>
            
        </div>
        
        <div class="sub_banner center">
            
            <c:if test="${empty hotGoodses}">
                <div class="datu fl"><a href=""><img src="./image/hongmi4x.png" alt=""></a></div>
                <div class="datu fl"><a href=""><img src="./image/hongmi4x.png" alt=""></a></div>
                <div class="datu fl"><a href=""><img src="./image/xiaomi5.jpg" alt=""></a></div>
                <div class="datu fl"><a href=""><img src="./image/pinghengche.jpg" alt=""></a></div>
            </c:if>
            <c:if test="${not empty hotGoodses}">
                <c:forEach items="${hotGoodses}" varStatus="s" var="hotGoods">
                    <div class="datu fl"><a href="/goods/detail/${hotGoods.goodsId}"><img
                            src="${hotGoods.goodsCoverImg}" alt=""></a></div>
                </c:forEach>
            </c:if>
            <div class="clear"></div>
        </div>
        <!-- end banner -->
        
        <!-- start danpin -->
        <div class="danpin center">
            
            <div class="biaoti center">新品上线</div>
            <!-- 当没有设置新品的时候，默认显示-->
            <div class="main center">
                <c:if test="${empty newGoodses}">
                    <div class="mingxing fl">
                        <div class="sub_mingxing"><a href=""><img src="./image/pinpai1.png" alt=""></a></div>
                        <div class="pinpai"><a href="">小米MIX</a></div>
                        <div class="youhui">5月9日-21日享花呗12期分期免息</div>
                        <div class="jiage">3499元起</div>
                    </div>
                    <div class="mingxing fl">
                        <div class="sub_mingxing"><a href=""><img src="./image/pinpai2.png" alt=""></a></div>
                        <div class="pinpai"><a href="">小米5s</a></div>
                        <div class="youhui">5月9日-10日，下单立减200元</div>
                        <div class="jiage">1999元</div>
                    </div>
                    <div class="mingxing fl">
                        <div class="sub_mingxing"><a href=""><img src="./image/pinpai3.png" alt=""></a></div>
                        <div class="pinpai"><a href="">小米手机5 64GB</a></div>
                        <div class="youhui">5月9日-10日，下单立减100元</div>
                        <div class="jiage">1799元</div>
                    </div>
                    <div class="mingxing fl">
                        <div class="sub_mingxing"><a href=""><img src="./image/pinpai4.png" alt=""></a></div>
                        <div class="pinpai"><a href="">小米电视3s 55英寸</a></div>
                        <div class="youhui">5月9日，下单立减200元</div>
                        <div class="jiage">3999元</div>
                    </div>
                    <div class="mingxing fl">
                        <div class="sub_mingxing"><a href=""><img src="./image/pinpai5.png" alt=""></a></div>
                        <div class="pinpai"><a href="">小米笔记本</a></div>
                        <div class="youhui">更轻更薄，像杂志一样随身携带</div>
                        <div class="jiage">3599元起</div>
                    </div>
                </c:if>
                
                <!-- 当设置了新品时候，显示的是 -->
                <c:if test="${not empty newGoodses}">
                    
                    <c:forEach items="${newGoodses}" var="newGoods" varStatus="s">
                        <div class="mingxing fl">
                            <div class="sub_mingxing"><a href="/goods/detail/${newGoods.goodsId}"><img
                                    src="${newGoods.goodsCoverImg}" alt=""></a></div>
                            <div class="pinpai"><a href="">${newGoods.goodsName}</a></div>
                            <div class="youhui">${newGoods.goodsIntro}</div>
                            <div class="jiage">${newGoods.sellingPrice}元起</div>
                        </div>
                    </c:forEach>
                </c:if>
                
                
                <div class="clear"></div>
            </div>
        </div>
        <div class="peijian w">
            <div class="biaoti center">为你推荐</div>
            <div class="main center">
                <div class="content">
                    
                    <!-- 没有配置为你推荐商品 -->
                    <c:if test="${ empty recommondGoodses}">
                        <div class="remen fl"><a href=""><img src="./image/peijian1.jpg"></a>
                        </div>
                        <div class="remen fl">
                            <div class="xinpin"><span>新品</span></div>
                            <div class="tu"><a href=""><img src="./image/peijian2.jpg"></a></div>
                            <div class="miaoshu"><a href="">小米6 硅胶保护套</a></div>
                            <div class="jiage">49元</div>
                            <div class="pingjia">372人评价</div>
                            <div class="piao">
                                <a href="">
                                    <span>发货速度很快！很配小米6！</span>
                                    <span>来至于mi狼牙的评价</span>
                                </a>
                            </div>
                        </div>
                        <div class="remen fl">
                            <div class="xinpin"><span style="background:#fff"></span></div>
                            <div class="tu"><a href=""><img src="./image/peijian3.jpg"></a></div>
                            <div class="miaoshu"><a href="">小米手机4c 小米4c 智能</a></div>
                            <div class="jiage">29元</div>
                            <div class="pingjia">372人评价</div>
                        </div>
                        <div class="remen fl">
                            <div class="xinpin"><span style="background:red">享6折</span></div>
                            <div class="tu"><a href=""><img src="./image/peijian4.jpg"></a></div>
                            <div class="miaoshu"><a href="">红米NOTE 4X 红米note4X</a></div>
                            <div class="jiage">19元</div>
                            <div class="pingjia">372人评价</div>
                            <div class="piao">
                                <a href="">
                                    <span>发货速度很快！很配小米6！</span>
                                    <span>来至于mi狼牙的评价</span>
                                </a>
                            </div>
                        </div>
                        <div class="remen fl">
                            <div class="xinpin"><span style="background:#fff"></span></div>
                            <div class="tu"><a href=""><img src="./image/peijian5.jpg"></a></div>
                            <div class="miaoshu"><a href="">小米支架式自拍杆</a></div>
                            <div class="jiage">89元</div>
                            <div class="pingjia">372人评价</div>
                            <div class="piao">
                                <a href="">
                                    <span>发货速度很快！很配小米6！</span>
                                    <span>来至于mi狼牙的评价</span>
                                </a>
                            </div>
                        </div>
                        <%--                        <div class="content">--%>
                        <div class="remen fl"><a href=""><img src="./image/peijian6.png"></a>
                        </div>
                        <div class="remen fl">
                            <div class="xinpin"><span style="background:#fff"></span></div>
                            <div class="tu"><a href=""><img src="./image/peijian7.jpg"></a></div>
                            <div class="miaoshu"><a href="">小米指环支架</a></div>
                            <div class="jiage">19元</div>
                            <div class="pingjia">372人评价</div>
                            <div class="piao">
                                <a href="">
                                    <span>发货速度很快！很配小米6！</span>
                                    <span>来至于mi狼牙的评价</span>
                                </a>
                            </div>
                        </div>
                        <div class="remen fl">
                            <div class="xinpin"><span style="background:#fff"></span></div>
                            <div class="tu"><a href=""><img src="./image/peijian8.jpg"></a></div>
                            <div class="miaoshu"><a href="">米家随身风扇</a></div>
                            <div class="jiage">19.9元</div>
                            <div class="pingjia">372人评价</div>
                        </div>
                        <div class="remen fl">
                            <div class="xinpin"><span style="background:#fff"></span></div>
                            <div class="tu"><a href=""><img src="./image/peijian9.jpg"></a></div>
                            <div class="miaoshu"><a href="">红米4X 高透软胶保护套</a></div>
                            <div class="jiage">59元</div>
                            <div class="pingjia">775人评价</div>
                        </div>
                        <div class="remenlast fl">
                            <div class="hongmi"><a href=""><img src="./image/hongmin4.png" alt=""></a></div>
                            <div class="liulangengduo"><a href=""><img src="./image/liulangengduo.png" alt=""></a></div>
                        </div>
                        <div class="clear"></div>
                        <%--                        </div>--%>
                    </c:if>
                    
                    <!-- 配置了为你推荐商品-->
                    <c:if test="${not empty recommondGoodses}">
                        <c:forEach items="${recommondGoodses}" var="recommondGoods" varStatus="s">
                            <div class="remen fl">
                                <div class="xinpin"><span style="background: red;">${recommondGoods.tag}</span></div>
                                <div class="tu"><a href="/goods/detail/${recommondGoods.goodsId}"><img
                                        src="${recommondGoods.goodsCoverImg}"></a></div>
                                <div class="miaoshu"><a
                                        href="/goods/detail/${recommondGoods.goodsId}">${recommondGoods.goodsName}</a>
                                </div>
                                <div class="jiage">${recommondGoods.sellingPrice}元</div>
                                <div class="piao">
                                    <a href="/goods/detail/${recommondGoods.goodsId}">
                                        <span>快到碗里来</span>
                                        <span>你才到碗里去,我要带走</span>
                                    </a>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
    </body>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/swiper.min.js"></script>
    <script src="/js/index.js"></script>
</html>