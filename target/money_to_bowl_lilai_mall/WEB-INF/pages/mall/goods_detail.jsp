<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>商品详情</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" type="text/css" href="/css/bootstrap-modal.css">
    </head>
    <body>
        <!-- start header -->
        <header>
            <div class="top center">
                <div class="left fl">
                    <ul>
                        <li><a href="/index" target="_blank">钱到碗里来商城</a></li>
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
                    <li><a href="">小米手机</a></li>
                    <li><a href="">红米</a></li>
                    <li><a href="">平板·笔记本</a></li>
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
                        <input type="text" class="shuru" id="keyword" placeholder="小米6&nbsp;小米MIX现货">
                    </div>
                <div class="submit fl">
                    <input type="submit"  id="btn-search" name="btn-search" class="sousuo" value="搜索" onclick="search();" />
                </div>
                    <div class="clear"></div>
                <div class="clear"></div>
            </div>
        </div>
        <!-- end banner_x -->
        
        
        <!-- xiangqing -->
            <div class="xiangqing">
                <div class="neirong w">
                    <div class="xiaomi6 fl">商品详情</div>
                    <nav class="fr">
                        <li><a href="##">概述</a></li>
                        <li>|</li>
                        <li><a href="##">详情</a></li>
                        <li>|</li>
                        <li><a href="##">用户评价</a></li>
                        <div class="clear"></div>
                    </nav>
                    <div class="clear"></div>
                </div>
            </div>
            
            <div class="jieshao mt20 w">
                <div class="left fl"><img src="${goodsDetail.goodsCoverImg}" style="width: 560px; height: 560px;"></div>
                <div class="right fr">
                    <div class="h3 ml20 mt20">${goodsDetail.goodsName}</div>
                    <br><br>
                    <div class="jianjie mr40 ml20 mt10">${goodsDetail.goodsIntro}</div>
                    <div class="jiage  mt10 fr">${goodsDetail.sellingPrice}.00元</div>
                    <br><br>
                    <div class="tb-extra ml20" id="J_tbExtra">
                        <dl>
                            <dt>承诺</dt>
                            <dd><a class="J_Cont" title="满足7天无理由退换货申请的前提下，包邮商品需要买家承担退货邮费，非包邮商品需要买家承担发货和退货邮费。" href="#"
                                   target="_blank"><img src="/image/others/7d.jpg">7天无理由</a></dd>
                        </dl>
                        <dl>
                            <dt>支付</dt>
                            <dd><a href="##" target="_blank"><img src="/image/others/hua.png">蚂蚁花呗</a><a href="##"
                                                                                                         target="_blank"><img
                                    th:src="@{/mall/image/card.png}">信用卡支付</a><a href="##" target="_blank"><img
                                    th:src="@{/mall/image/ji.png}">集分宝</a></dd>
                        </dl>
                        <dl>
                            <dt>支持</dt>
                            <dd>折旧变现，买新更省钱。<a style="float:none;text-decoration: underline;" href="##">详情</a></dd>
                        </dl>
                    
                    </div>
                    <div class="xiadan ml20 mt20">
                        <input class="jrgwc" id="buyNow" type="button" name="ljxg" value="立即选购"
                               onclick="saveAndGoCart(${goodsDetail.goodsId});" />
                        <input class="jrgwc" id="saveToCart" type="button" name="jrgwc" value="加入购物车"
                               onclick="saveToCart(${goodsDetail.goodsId});" />
                    
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        <div class="mt20 w clearfix goods">${goodsDetail.goodsDetailContent}</div>
        <!-- footer -->
    
    </body>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/swiper.min.js"></script>
    <script src="/js/sweetalert.min.js"></script>
    <script src="/js/index.js"></script>
    <script type="text/javascript">


        //立即选购
        function saveAndGoCart(goodsId) {

            var goodsCount = 1;
            var data = {
                goodsId: goodsId,
                goodsCount: goodsCount
            }

            $.ajax({
                type: 'POST',
                url: '/shop-cart',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {

                    if (result.resultCode == 200) {
                        swal({
                            title: "已经将商品添加到购物车中",
                            icon: "success",
                            buttons: {
                                cancel: "留在当前页",
                                confirm: "老板！买单"
                            },
                            dangerMode: false,
                        }).then((flag) => {
                            if(flag) {
                                window.location.href = '/shop-cart';
                            }
                        }
                    )
                        ;
                    } else {
                        swal(result.message, {
                            icon: "error",
                        })
                    }
                },
                error: function () {
                    swal("操作失败", {
                        icon: "error",
                    })
                }

            })
        }


        //加入购物车
        function saveToCart(goodsId) {

            var goodsCount = 1;
            var data = {
                goodsId: goodsId,
                goodsCount: goodsCount
            }

            $.ajax({
                type: 'POST',
                url: '/shop-cart',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                    if (result.resultCode == 200) {
                        swal({
                            title: "添加成功！",
                            text: "确认框",
                            icon: "success",
                            buttons: true,
                            dangerMode: true,
                        }).then((flag) => {
                            window.location.reload();
                        }
                    );
                    } else {
                        swal(result.message, {
                            icon: "error",
                        })
                    }
                },
                error: function () {
                    swal("操作失败", {
                        icon: "error",
                    })
                }
            })
        }
    
    </script>
</html>