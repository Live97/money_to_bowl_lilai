<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>商城-订单详情</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" type="text/css" href="/css/bootstrap-modal.css">
        <link rel="stylesheet" type="text/css" href="/css/my-orders.css">
        <link rel="stylesheet" type="text/css" href="/css/order-detail.css">
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
                <div class="money_logo fl"><img src="/image/others/logo2.jpg"></div>
            </a>
            <a href="">
                <div class="ad_top fl"></div>
            </a>
            <div class="nav_top fl">
                <ul>
                    <li><a href="/index" target="_self">手机</a></li>
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
                <div class="clear"></div>
            </div>
        </div>
        <!-- end banner_x -->
        <!-- self_info -->
        <div class="grzxbj">
            <div class="selfinfo center">
                <div class="lfnav fl">
                    <div class="ddzx">个人中心</div>
                    <div class="subddzx">
                        <ul>
                            <li><a href="/personal">个人中心</a></li>
                            <li><a href="/order">我的订单</a></li>
                            <li><a href="/logout">退出登录</a></li>
                        </ul>
                    </div>
                </div>
                
                
                <div class="rtcont fr">
                    <div class="uc-box uc-main-box">
                        <div class="uc-content-box order-view-box">
                            <div class="box-hd">
                                <h1 class="title">订单详情
                                </h1>
                                <div class="more clearfix">
                                    <h2 class="subtitle">订单号:
                                        ${orderDetail.order_number}
                                        <span class="tag tag-subsidy"></span>
                                    </h2>
                                    <!-- 按钮格式 -->
                                    <div class="actions">
                                        <input type="hidden" value="${orderDetail.order_number}" id="orderNo">
                                        <c:if test="${orderDetail.order_status == 0}">
                                            <a id="toPayMoney" class="btn btn-small btn-primary" title="去支付"
                                               onclick="payOrder();">去支付</a>
                                        </c:if>
                                        <c:if test="${orderDetail.order_status == 3}">
                                            <a id="toSubmit" class="btn btn-small btn-primary" title="确认收货"
                                               onclick="finishOrder();">确认收货</a>
                                        </c:if>
                                        <c:if test="${orderDetail.order_status > 0 and orderDetail.order_status < 3}">
                                            <a id="toCancel" class="btn btn-small btn-line-gray" title="取消订单"
                                               onclick="cancelOrder();">取消订单</a>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                            <div class="box-hd">
                                <div class="uc-order-item uc-order-item-pay">
                                    <div class="order-detail">
                                        <!-- 进度条 -->
                                        <div class="order-summary">
                                            
                                            <!-- 中文显示订单状态 -->
                                            <div class="order-status">
                                                ${orderDetail.orderStatusString}
                                            </div>
                                            <!-- 友好提示，根据订单每个状态进行不同的显示 -->
                                            <div class="order-desc">
                                                <c:if test="${orderDetail.order_status == 0}">请尽快完成支付哦~</c:if>
                                                <c:if test="${orderDetail.order_status == 1}">商城订单确认中</c:if>
                                                <c:if test="${orderDetail.order_status == 2}">仓库正在紧急配货中</c:if>
                                                <c:if test="${orderDetail.order_status == 3}">订单已出库正在快马加鞭向您奔来</c:if>
                                                <c:if test="${orderDetail.order_status == 4}">交易成功，感谢您对钱到碗里来商城的支持~</c:if>
                                            </div>
                                            
                                            <c:if test="${orderDetail.order_status >= 0}">
                                                
                                                <!--todo 进度条也是根据状态而改变-->
                                                <div class="order-progress">
                                                    <ol class="progress-list clearfix progress-list-5">
                                                        <c:if test="${orderDetail.order_status == 0}">
                                                        <li class="step step-active">
                                                            </c:if>
                                                            <c:if test="${orderDetail.order_status > 0}">
                                                        <li class="step step-first">
                                                            </c:if>
                                                            <div class="progress"><span class="text">下单</span></div>
                                                            <div class="info">
                                                                <!-- 显示订单创建时间-->
                                                                <fmt:formatDate value="${orderDetail.create_time}"
                                                                                pattern="yyyy-MM-dd HH:mm:ss" />
                                                            </div>
                                                        </li>
                                                        
                                                        <c:if test="${orderDetail.order_status < 1}">
                                                        <li class="step">
                                                            </c:if>
                                                            <c:if test="${orderDetail.order_status == 1}">
                                                        <li class="step step-active">
                                                            </c:if>
                                                            <c:if test="${orderDetail.order_status > 1}">
                                                        <li class="step step-done">
                                                            </c:if>
                                                            <div class="progress"><span class="text">付款</span></div>
                                                            <div class="info"></div>
                                                        </li>
                                                        
                                                        <c:if test="${orderDetail.order_status < 2}">
                                                        <li class="step">
                                                            </c:if>
                                                            <c:if test="${orderDetail.order_status == 2}">
                                                        <li class="step step-active">
                                                            </c:if>
                                                            <c:if test="${orderDetail.order_status > 2}">
                                                        <li class="step step-done">
                                                            </c:if>
                                                            <div class="progress"><span class="text">配货</span></div>
                                                            <div class="info"></div>
                                                        </li>
                                                        
                                                        
                                                        <c:if test="${orderDetail.order_status < 3}">
                                                        <li class="step">
                                                            </c:if>
                                                            <c:if test="${orderDetail.order_status == 3}">
                                                        <li class="step step-active">
                                                            </c:if>
                                                            <c:if test="${orderDetail.order_status > 3}">
                                                        <li class="step step-done">
                                                            </c:if>
                                                            <div class="progress"><span class="text">出库</span></div>
                                                            <div class="info"></div>
                                                        </li>
                                                        
                                                        
                                                        <c:if test="${orderDetail.order_status < 4}">
                                                        <li class="step">
                                                            </c:if>
                                                            <c:if test="${orderDetail.order_status == 4}">
                                                        <li class="step step-active">
                                                            </c:if>
                                                            <c:if test="${orderDetail.order_status > 4}">
                                                        <li class="step step-last">
                                                            </c:if>
                                                            <div class="progress"><span class="text">交易成功</span></div>
                                                            <div class="info"></div>
                                                        </li>
                                                    </ol>
                                                </div>
                                            </c:if>
                                        </div>
                                        
                                        <!-- 订单信息 图片/商品名/价格/数量-->
                                        <table class="order-items-table">
                                            <tbody>
                                                <c:forEach items="${orderDetail.mallOrderItemVOS}" var="result"
                                                           varStatus="s">
                                                    <tr>
                                                        <td class="col col-thumb">
                                                            <div class="figure figure-thumb">
                                                                <a target="_blank"
                                                                   href="/goods/detail/${result.goodsId}">
                                                                    <img src="${result.goodsCoverImg}"
                                                                         style="width: 80px;height: 80px;" alt="">
                                                                </a>
                                                            </div>
                                                        </td>
                                                        <td class="col col-name">
                                                            <p class="name">
                                                                <a href="/goods/detail/${result.goodsId}">${result.goodsName}</a>
                                                            </p>
                                                        </td>
                                                        <td class="col col-price">
                                                            <p class="price">${result.sellingPrice}元
                                                                                                   x ${result.goodsCount}</p>
                                                        </td>
                                                        <td class="col col-actions">
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    
                                    <!-- 收货地址 -->
                                    <div class="order-detail-info" id="changeAddress">
                                        <table class="info-table">
                                            <h3>收货信息</h3>
                                            <tbody>
                                                <tr>
                                                    <th>收货地址：</th>
                                                    <td class="user_address_label">
                                                        ${MallUser.address == ''?'无':MallUser.address}
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    
                                    <!-- 支付方式 -->
                                    <div class="order-detail-info" id="editorTime">
                                        <h3>支付方式</h3>
                                        <table class="info-table">
                                            <tbody>
                                                <tr>
                                                    <th>支付方式：</th>
                                                    <td>${orderDetail.payTypeString == null? '在线支付':orderDetail.payTypeString}</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <div class="actions">
                                        </div>
                                    </div>
                                    
                                    <!-- 商品总价 -->
                                    <div class="order-detail-total">
                                        <table class="total-table">
                                            <tbody>
                                                <tr>
                                                    <th>运费：</th>
                                                    <td><span class="num">0</span>元</td>
                                                </tr>
                                                <tr>
                                                    <th class="total">商品总价：</th>
                                                    <td class="total"><span
                                                            class="num">${orderDetail.total_price}.00</span>元
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
        <!-- self_info -->
    </body>
    
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/bootstrap3.js"></script>
    <script src="/js/sweetalert.min.js"></script>
    
    <script type="text/javascript">

        //点击跳转支付订单页面
        function payOrder() {

            var orderNo = $("#orderNo").val();
            window.location.href = '/selectPayType?orderNo=' + orderNo;
        }

        //点击确认收货
        function finishOrder() {
            var orderNo = $("#orderNo").val();
            $.ajax({

                type: "POST",
                url: "/order/" + orderNo + '/finish',
                success: function (result) {
                    if (result.resultCode == 200) {
                        window.location.reload();
                    } else {
                        swal(result.message, {
                            icon: "error"
                        });
                    }
                },
                error: function () {
                    swal("操作失败!", {
                        icon: "error"
                    });
                }
            })
        }

        //点击取消订单
        function cancelOrder() {

            var orderNo = $("#orderNo").val();

            swal({
                title: "客观请注意",
                text: "确定要取消订单吗?",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            }).then((flag) => {

                if(flag) {
                    $.ajax({
                        type: "POST",
                        url: "/order/" + orderNo + "/cancel",
                        success: function (result) {
                            if (result.resultCode == 200) {
                                window.location.reload();
                            } else {
                                swal(result.message, {
                                    icon: "error"
                                });
                            }
                        },
                        error: function () {
                            swal("操作失败！", {
                                icon: "error"
                            });
                        }
                    });
                }
            }
        )
        ;
    }
    </script>
</html>