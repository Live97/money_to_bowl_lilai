<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>支付界面---微信支付</title>
        <link type="text/css" rel="stylesheet" href="/css/pay.css">
        <script src="/js/jquery-3.2.1.min.js"></script>
    </head>
    <body>
        <div class="body">
            <h1 class="mod-title">
                <span class="ico_log icon-wx-pay"></span>
            </h1>
            
            <div class="mod-ct">
                <div class="order">
                </div>
                <div class="amount" id="money">￥
                    ${totalPrice}.00元
                </div>
                <div class="qrcode-img-wrapper" data-role="qrPayImgWrapper">
                    <div data-role="qrPayImg" class="qrcode-img-area">
                        <div class="ui-loading qrcode-loading" data-role="qrPayImgLoading"></div>
                        <div style="position: relative;display: inline-block;">
                            <img width="300" height="300"
                                 src="/image/others/pay/wxpay.png"
                                 title="请尽快支付~"
                                 style="display: block;">
                        </div>
                    </div>
                </div>
                
                <div class="time-item" style="padding-top: 10px">
                    <div class="time-item" id="msg">
                        <h1>支付完成后，将跳转至订单详情</h1>
                    </div>
                    <div class="time-item">
                        <h1>订单:
                            ${orderNo}
                        </h1>
                    </div>
                    <input type="hidden" id="orderNoValue" value="${orderNo}">
                </div>
                
                <div class="tip">
                    <div class="ico-scan-wx"></div>
                    <div class="tip-text">
                        <p id="showtext">打开微信 [扫一扫]</p>
                    </div>
                    <div class="tip-text">
                        <a onclick="payOrderSuccess()"
                           class="btn btn-small btn-success" title="支付成功">支付成功</a>
                    </div>
                </div>
                
                <div class="tip-text">
                </div>
            
            </div>
            <div class="foot">
            </div>
        </div>
        <script type="text/javascript">
            function payOrderSuccess() {
                var orderNo = $("#orderNoValue").val();
                $.ajax({
                    type: 'GET',
                    url: '/paySuccess?payType=2&orderNo=' + orderNo,
                    success: function (result) {
                        if (result.resultCode == 200) {
                            window.location.href = '/order/' + orderNo;
                        } else {
                            alert(result.message);
                        }
                    },
                    error: function () {
                        alert("操作失败");
                    }
                });
            }
        </script>
    </body>
</html>
