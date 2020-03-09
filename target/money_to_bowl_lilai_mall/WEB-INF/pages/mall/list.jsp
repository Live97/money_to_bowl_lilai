<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
       
        <title>搜索列表</title>
    
        <link href="/css/style.css" rel="stylesheet">
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
                    <div class="gouwuche fr"><a href="/shop-cart">购物车</a></div>
                    <div class="fr">
                        <c:if test="${MallUser != null}">
                            <div class="user">
                                <div class="selector">
                                    <ul>
                                        <li><a href="/index">返回首页</a></li>
                                        <li><a href="/logout">退出登录</a></li>
                                    </ul>
                                </div>
                                <a href="#" class="username">${MallUser.user_nick_name}</a>
                            </div>
                        
                        </c:if>
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
            <div class="nav_top fl">
                <ul>
                    <li><a href="/search?keyword=手机" target="_self">手机</a></li>
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
                    <input type="text" class="shuru" name="keyword" id="keyword" placeholder="小米6&nbsp;小米MIX现货">
                </div>
                <div class="submit fl">
                    <input type="submit" class="sousuo" value="搜索" onclick="search();" />
                </div>
                <div class="clear"></div>
                <div class="clear"></div>
            </div>
        </div>
        <!-- end banner_x -->
        
        <!-- start banner_y -->
        <!-- end banner -->
        
        <!-- start danpin -->
        <div class="danpin center">
            
            <div class="biaoti center">搜索"${keyword}"</div>
            <div class="main center">
                <c:if test="${empty pageResult.list}">
                    <p>未查询到记录</p>
                </c:if>
                <c:if test="${not empty pageResult.list}">
                    <c:forEach items="${pageResult.list}" var="searchResult" varStatus="s">
                        <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;"
                             onmouseout="this.style.border='2px solid #fff'"
                             onmousemove="this.style.border='2px solid red'">
                            <div class="sub_mingxing"><a href="/goods/detail/${searchResult.goodsId}"
                                                         target="_blank"><img src="${searchResult.goodsCoverImg}"
                                                                              alt=""></a></div>
                            <div class="pinpai"><a href="/goods/detail/${searchResult.goodsId}"
                                                   target="_blank">${searchResult.goodsName}</a></div>
                            <div class="youhui">${searchResult.goodsIntro}</div>
                            <div class="jiage">${searchResult.sellingPrice}.00元</div>
                        </div>
                    </c:forEach>
                </c:if>
                <%--                <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">--%>
                <%--                    <div class="sub_mingxing"><a href="${}" target="_blank"><img src="./image/liebiao_xiaomi6.jpg" alt=""></a></div>--%>
                <%--                    <div class="pinpai"><a href="./xiangqing.html" target="_blank">小米6</a></div>--%>
                <%--                    <div class="youhui">5.16早10点开售</div>--%>
                <%--                    <div class="jiage">2499.00元</div>--%>
                <%--                </div>--%>
                
                <div class="clear"></div>
            </div>
        </div>
        
        <!-- end danpin -->
        <script src="/js/jquery-3.2.1.min.js"></script>
        <script src="/js/bootstrap.min.js"></script>
        <script src="/js/swiper.min.js"></script>
        <script src="/js/sweetalert.min.js"></script>
        <script src="/js/index.js"></script>
    </body>

</html>