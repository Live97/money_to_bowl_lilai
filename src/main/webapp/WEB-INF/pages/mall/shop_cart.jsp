<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="author" content="order by dede58.com" />
        <title>我的购物车</title>
        <link rel="stylesheet" type="text/css" href="./css/style.css">
    </head>
    <body>
        <!-- start header -->
        <!--end header -->
        
        <!-- start banner_x -->
        <div class="banner_x center">
            <a href="/index" target="_blank">
                <div class="money_logo fl"><img src="/image/others/logo2.jpg"></div>
            </a>
            <div class="wdgwc fl ml40">我的购物车</div>
            <div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
            <div class="clear"></div>
        </div>
        <div class="xiantiao"></div>
        <div class="gwcxqbj">
            <div class="gwcxd center">
                <div class="top2 center">
                    <div class="sub_top fl">
                        <input type="checkbox" value="quanxuan" class="selectAll" onclick="selectAll(this)" />全选
                    </div>
                    <div class="sub_top fl">商品名称</div>
                    <div class="sub_top fl">单价</div>
                    <div class="sub_top fl">数量</div>
                    <div class="sub_top fl">小计</div>
                    <div class="sub_top fl">操作</div>
                    <div class="clear"></div>
                </div>
                
                <!--直接渲染上去,是个list集合-->
                <!-- 购物车中有数据 -->
                <c:if test="${not empty shopCartResult}">
                    <c:forEach items="${shopCartResult}" var="item" varStatus="s">
                        <div class="content2 center">
                            <div class="sub_content fl ">
                                <input type="checkbox" value="${item.cartItemId}" class="quanxuan" />
                            </div>
                            <div class="sub_content fl"><img src="${item.goodsCoverImg}"
                                                             style="width:80px; height: 80px;"></div>
                            <div class="sub_content fl ft20">${item.goodsName}</div>
                            <div class="sub_content fl ">${item.sellingPrice}元</div>
                            <div class="sub_content fl">
                                <input class="shuliang" id="goodsCount${item.cartItemId}" type="number"
                                       value="${item.goodsCount}"
                                       step="1"
                                       min="1" max="5"
                                       onblur="updateGoodsCount(${item.cartItemId});">
                            </div>
                            <div class="sub_content fl">${item.sellingPrice * item.goodsCount}元</div>
                            <div class="sub_content fl"><a href="#" onclick="deleteItem(${item.cartItemId});">×</a>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${empty shopCartResult}">
                    <img src="/image/others/nullnullruye.jpg" width="1226px">
                </c:if>
                
                <div class="clear"></div>
            </div>
            <div class="jiesuandan mt20 center">
                <div class="tishi fl ml20">
                    <ul>
                        <li><a href="/index">继续购物</a></li>
                        <li>|</li>
                        <li>共<span>${itemTotal}</span>件商品</li>
                        <div class="clear"></div>
                    </ul>
                </div>
                <div class="jiesuan fr">
                    <div class="jiesuanjiage fl">
                        合计（不含运费）：<span>${priceTotal}.00元</span></div>
                    <c:if test="${empty shopCartResult}">
                        <div class="jsanniu fr"><input class="jsan" type="submit" name="jiesuan" value="去结算"
                                                       onclick="noGoodsError();" /></div>
                    </c:if>
                    <c:if test="${not empty shopCartResult}">
                            <div class="jsanniu fr"><input class="jsan" type="submit" name="jiesuan" value="去结算"
                                                           onclick="settle();" /></div>
                    </c:if>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
        
        </div>
    
    
    </body>
    
    <script src="/js/jquery.min.js"></script>
    <script src="/js/sweetalert.min.js"></script>
    <script src="/js/swiper.min.js"></script>
    <script type="text/javascript">

        /**
         * 全选/全不选功能
         */
        function selectAll(obj) {
            $(".quanxuan").prop("checked", obj.checked);
        }

        /**
         * 根据购物车id去删除购物车中的商品项
         * @param obj
         */
        function deleteItem(id) {

            //友好提示
            swal({
                title: "确认弹框",
                text: "确认不买该商品了吗？",
                icon: "warning",
                buttons: true,
                dangerMode: true,
            }).then((flag) => {

                if(flag) {
                    $.ajax({
                        type: "DELETE",
                        url: "/shop-cart/" + id,
                        success: function (result) {
                            if (result.resultCode == 200) {
                                //删除成功，直接刷新页面即可
                                window.location.reload();
                            } else {
                                swal(result.message, {
                                    icon: "error",
                                });
                            }
                        },
                        error: function () {
                            swal("操作失败", {
                                icon: "error",
                            });
                        }
                    })
                }
            }
        )
            ;
        }


        /**
         * 根据购物车id去更新购物车商品项信息
         */
        function updateGoodsCount(id) {

            var domId = 'goodsCount' + id;
            var goodsCount = $("#" + domId).val();

            if (goodsCount > 5) {
                swal("单个商品最多只可以购买5个", {
                    icon: "error",
                });
            }
            if (goodsCount < 1) {
                swal("数据错误", {
                    icon: "error",
                });
            }

            var data = {
                "cartItemId": id,
                "goodsCount": goodsCount,
            }
            $.ajax({
                type: "PUT",
                url: "shop-cart",
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (result) {
                    if (result.resultCode == 200) {
                        //直接刷新网页即可
                        window.location.reload();
                    } else {
                        swal(result.message, {
                            icon: "error",
                        });
                        $("#" + domId).val(5)
                    }
                },
                error: function () {
                    swal("操作失败", {
                        icon: "error",
                    });
                }
            })
        }

        /**
         * 购物车中没有商品，点击结算回显示的信息
         */
        function noGoodsError() {

            var flag = false;
            var quanxuan = document.getElementsByClassName("quanxuan");
            for (var i = 0; i < quanxuan.length; i++) {
                if (quanxuan[i].innerHTML != true) {
                    continue;
                }
                flag = true;
            }

            if (!flag) {
                swal({
                    title: "购物车中并有商品，无法进行结算",
                    icon: "error",
                });
            }


        }

        /**
         * 购物车中有商品，点击结算跳转到结算页面
         */
        function settle() {

            //todo 判断是否选中商品
            var flag = false;
            var quanxuan = document.getElementsByClassName("quanxuan");

            var cartItemId = [];
            for (var i = 0; i < quanxuan.length; i++) {
                if ($(quanxuan[i]).is(':checked')) {
                    //有选择就将value属性放入数组中
                    cartItemId.push($(quanxuan[i]).val());
                    flag = true;
                }
            }

            if (!flag) {
                swal({
                    title: "请选中需要结算的商品",
                    icon: "error",
                });
            } else {
                window.location.href="/shop-cart/settle?cartItemId=" + cartItemId;
            }

        }
    </script>
</html>
