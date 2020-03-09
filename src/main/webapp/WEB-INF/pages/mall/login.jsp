<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="author" content="order by dede58.com" />
        <title>用户登录</title>
        <link rel="stylesheet" type="text/css" href="./css/login.css">

    </head>
    <body>
        <!-- login -->
        <div class="top center">
        </div>
        <form id="loginForm" method="post" action="##" class="form center" onsubmit="return false;">
            <div class="login">
                <div class="login_center">
                    <div class="login_top">
                        <div class="left fl">会员登录</div>
                        <div class="right fr">您还不是我们的会员？<a href="/register" target="_self">立即注册</a></div>
                        <div class="clear"></div>
                        <div class="xian center"></div>
                    </div>
                    <div class="login_main center">
                        <div class="username">用户名:&nbsp;<input class="shurukuang" type="text" name="username"
                                                               placeholder="请输入你的用户名" /></div>
                        <div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input class="shurukuang" type="password"
                                                                                      name="password"
                                                                                      placeholder="请输入你的密码" /></div>
                        <div class="username">
                            <div class="left fl">验证码:&nbsp;<input class="yanzhengma" type="text" name="verifyCode"
                                                                  placeholder="请输入验证码" /></div>
                            <div class="right fl"><img src="./image/yanzhengma.jpg"></div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="login_submit">
                        <input class="submit" type="submit" name="submit" onclick="login()" value="立即登录">
                    </div>

                </div>
            </div>
        </form>
        <footer>
            <div class="copyright">简体 | 繁体 | English | 常见问题</div>
            <div class="copyright">Money_To_Bowl_lilai<img src="./image/ghs.png" alt="">华商416190123
            </div>

        </footer>
    </body>
    <%-- 引入外部js插件 --%>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/sweetalert.min.js"></script>
    <script src="/js/swiper.min.js"></script>

    <script type="text/javascript">

        function login() {
            //验证操作
            //获取loginForm表单的请求参数列表，将其序列化成 请求参数1=值&请求参数2=值&...
            var params = $("#loginForm").serialize();
            var url = '/login';
            //发送异步请求
            $.ajax({
                type: "POST",
                url: url,
                data: params,
                // contentType:"application/json;charset=utf-8",
                // dataType:"json",
                success: function (result) {

                    if (result.resultCode == 200) {

                        window.location.href = "/index";
                    } else {
                        swal(result.message, {
                            icon: "error",
                        });
                    }
                },
                error: function (result) {

                    swal("操作失败", {
                        icon: "error",
                    });
                }

            })
        }
        


    </script>
</html>