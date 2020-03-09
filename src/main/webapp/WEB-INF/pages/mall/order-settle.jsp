<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>钱到碗里来商城-订单结算</title>
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
                                <h1 class="title">填写并核对订单信息</h1>
                                <div class="more clearfix">
                                    <div class="actions">
                                        <a id="saveOrder" class="btn btn-small btn-primary" title="提交订单">提交订单</a>
                                    </div>
                                </div>
                            </div>
                            <div class="box-hd">
                                <div class="uc-order-item uc-order-item-pay">
                                    <div class="order-detail">
                                        <!-- 进度条 -->
                                        <div class="order-summary">
                                            <div class="order-progress">
                                                <ol class="progress-list clearfix progress-list-5">
                                                    <li class="step step-done">
                                                        <div class="progress"><span class="text">购物车</span></div>
                                                        <div class="info"></div>
                                                    </li>
                                                    <li class="step step-active">
                                                        <div class="progress"><span class="text">下单</span></div>
                                                        <div class="info"></div>
                                                    </li>
                                                    <li class="step">
                                                        <div class="progress"><span class="text">付款</span></div>
                                                        <div class="info"></div>
                                                    </li>
                                                    <li class="step">
                                                        <div class="progress"><span class="text">出库</span></div>
                                                        <div class="info"></div>
                                                    </li>
                                                    <li class="step">
                                                        <div class="progress"><span class="text">交易成功</span></div>
                                                        <div class="info"></div>
                                                    </li>
                                                </ol>
                                            </div>
                                        </div>
                                        
                                        <!-- 订单信息 图片/商品名/价格/数量-->
                                        <table class="order-items-table">
                                            
                                            <tbody>
                                                <c:forEach items="${myShoppingCartItems}" var="result" varStatus="s">
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
                                        <div class="actions">
                                            <a class="btn btn-small btn-line-gray J_editAddr"
                                               href="javascript:openUpdateModal();">修改</a>
                                        </div>
                                    </div>
                                    
                                    <!-- 支付方式 -->
                                    <div class="order-detail-info" id="editorTime">
                                        <h3>支付方式</h3>
                                        <table class="info-table">
                                            <tbody>
                                                <tr>
                                                    <th>支付方式：</th>
                                                    <td>在线支付</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <div class="actions">
                                            </table>
                                        </div>
                                    </div>
                                    
                                    <!-- 商品总价 -->
                                    <div class="order-detail-total">
                                        <table class="total-table">
                                            <tbody>
                                                <tr>
                                                    <th>商品总价：</th>
                                                    <td><span class="num">${payMoney}.00</span>元</td>
                                                </tr>
                                                <tr>
                                                    <th>运费：</th>
                                                    <td><span class="num">0</span>元</td>
                                                </tr>
                                                <tr>
                                                    <th class="total">应付金额：</th>
                                                    <td class="total"><span class="num">${payMoney}.00</span>元
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    
                                    <!-- 更改地址信息模态框 -->
                                    <div class="modal fade" id="personalInfoModal" tabindex="-1" role="dialog"
                                         aria-labelledby="personalInfoModalLabel">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal"
                                                            aria-label="Close"><span
                                                            aria-hidden="true"></span></button>
                                                    <h4 class="modal-title" id="personalInfoModalLabel">个人信息修改</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <form id="personalInfoForm">
                                                        
                                                        <div class="form-group">
                                                            <input type="hidden" id="userId" value="${MallUser.user_id}">
                                                            <label for="address" class="control-label">收货信息:</label>
                                                            <input type="text" class="form-control" id="address"
                                                                   name="address"
                                                                   placeholder="请输入收货信息" value="${MallUser.address}"
                                                                   required="true">
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">
                                                        取消
                                                    </button>
                                                    <button type="button" class="btn btn-primary" id="saveButton">确认
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
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
        
        <script type="text/javascript">

            //提交订单
            $("#saveOrder").click(function () {

                //判断地址有没有填写
                var address = $(".user_address_label").html();
                if (address == '无' || address == '') {
                    swal("请填写收货地址", {
                        icon: "error",
                    });
                    return;
                }
                if (address.length < 10) {
                    swal("请填写正确的地址信息", {
                        icon: "error",
                    });
                    return;
                }
                //提交订单
                window.location.href = '../saveOrder';

            })

            //调出模块框
            function openUpdateModal() {
                $('#personalInfoModal').modal('show');
            }

            //模态框确认按钮触发
            $("#saveButton").click(function () {

                var user_id = $("#userId").val();
                var user_address = $("#address").val();

                var data = {
                    "user_id": user_id,
                    "address": user_address,
                };

                $.ajax({
                    type: "POST",
                    url: "/personal/updateInfo",
                    contentType: "application/json",
                    data: JSON.stringify(data),
                    success: function (result) {

                        if (result.resultCode == 200) {
                            $("#personalInfoModal").modal('hide');
                            window.location.reload();
                        } else {
                            $("#personalInfoModal").modal('hide');
                            alert(result.message);
                        }
                    },
                    error: function () {
                        alert("操作失败!");
                    }
                })
            })
        </script>
    </body>
</html>
