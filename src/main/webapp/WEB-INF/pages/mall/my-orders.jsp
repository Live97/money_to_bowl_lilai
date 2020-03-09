<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>商城-我的订单</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" type="text/css" href="/css/bootstrap-modal.css">
        <link rel="stylesheet" type="text/css" href="/css/my-orders.css">
    </head>
    <body>
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
        
        
        <div class="banner_x center">
            <a href="/index" target="_blank">
                <div class="money_logo fl"><img src="/image/others/logo2.jpg"></div>
            </a>
            <div class="nav_top fl">
                <ul>
                    <li><a href="/index" target="_blank">手机</a></li>
                    <li><a href="">耳机</a></li>
                    <li><a href="">电脑</a></li>
                    <li><a href="">电视</a></li>
                    <li><a href="">盒子·影音</a></li>
                    <li><a href="">路由器</a></li>
                    <li><a href="">智能硬件</a></li>
                    <li><a href="">服务</a></li>
                    <li><a href="">社区</a></li>
                </ul>
            </div>
            <div class="search fr">
                <div class="text fl">
                    <input type="text" class="shuru" placeholder="小米6&nbsp;小米MIX现货">
                </div>
                <div class="submit fl">
                    <input type="submit" class="sousuo" value="搜索" />
                </div>
                <div class="clear"></div>
            </div>
        </div>
        
        <div class="grzxbj">
            <div class="selfinfo center">
                <%-- sidebar --%>
                <div class="lfnav fl">
                    <div class="ddzx">个人中心</div>
                    <div class="subddzx">
                        <ul>
                            <li><a href="/personal">个人中心</a></li>
                            <li><a href="/order" style="color:#ff6700;font-weight:bold;">我的订单</a></li>
                            <li><a href="/logout">退出登录</a></li>
                        </ul>
                    </div>
                </div>
                
                
                <div class="rtcont fr">
                    <div class="uc-box uc-main-box">
                        <div class="uc-content-box order-list-box">
                            <div class="box-hd">
                                <h1 class="title">我的订单</h1>
                            </div>
                            <div class="box-hd">
                                <div id="J_orderList">
                                    <ul class="order-list">
                                        <c:if test="${empty orderPageResult}">
                                            <!-- todo 无订单时 换背景图为无订单 -->
                                        </c:if>
                                        <c:forEach items="${orderPageResult.list}" var="orderResult">
                                            <li class="uc-order-item uc-order-item-list">
                                                <div class="order-detail">
                                                    <div class="order-summary">
                                                        <c:if test="${orderResult.order_status < 0}">
                                                        <div class="order-status-closed">
                                                            </c:if>
                                                            <c:if test="${orderResult.order_status == 0}">
                                                            <div class="order-status-need-pay">
                                                                </c:if>
                                                                <c:if test="${orderResult.order_status > 0}">
                                                                <div class="order-status-success">
                                                                    </c:if>
                                                                        ${orderResult.orderStatusString}
                                                                </div>
                                                            </div>
                                                            <table class="order-detail-table">
                                                                <thead>
                                                                    <tr>
                                                                        <th class="col-main">
                                                                            <p class="caption-info">
                                                                                <fmt:formatDate
                                                                                        value="${orderResult.create_time}"
                                                                                        pattern="yyyy-MM-dd HH:mm:ss" />
                                                                                <span class="sep">|</span>订单号：
                                                                                <a href="##">${orderResult.order_number}</a>
                                                                                <span class="sep">|</span>在线支付
                                                                            </p>
                                                                        </th>
                                                                        <th class="col-sub"><p class="caption-price">
                                                                            应付金额：<span
                                                                                class="num">${orderResult.total_price}</span>元
                                                                        </p></th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <td class="order-items">
                                                                                <ul class="goods-list">
                                                                                    <c:forEach items="${orderResult.mallOrderItemVOS}" var="item">
                                                                                        <li>
                                                                                            <div class="figure figure-thumb">
                                                                                                <a target="_blank"
                                                                                                   href="/goods/detail/${item.goodsId}">
                                                                                                    <img src="${item.goodsCoverImg}"
                                                                                                         style="width: 80px; height: 80px;"
                                                                                                         alt="">
                                                                                                </a>
                                                                                            </div>
                                                                                            <p class="name">
                                                                                                <a target="_blank"
                                                                                                   href="/goods/detail/${item.goodsId}">${item.goodsName}</a>
                                                                                            </p>
                                                                                            <p class="price">
                                                                                                    ${item.sellingPrice}
                                                                                                × ${item.goodsCount}
                                                                                            </p>
                                                                                        </li>
                                                                                    </c:forEach>
                                                                                </ul>
                                                                        </td>
                                                                        <td class="order-actions">
                                                                            <a class="btn btn-small btn-line-gray"
                                                                               href="/order/${orderResult.order_number}">订单详情
                                                                            </a>
                                                                        </td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            
                            
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script src="/js/jquery-3.2.1.min.js"></script>
        <script src="/js/bootstrap.min.js"></script>
        <!-- 模态框需要bootstrap3 上面的不行。。。 -->
        <script src="/js/bootstrap3.js"></script>
        <script src="/js/sweetalert.min.js"></script>
    
    </body>
</html>
