<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
        <title>用户注册</title>
        <link rel="stylesheet" type="text/css" href="./css/login.css">

    </head>
    <body>
        <form  method="post" action="##" id="registerForm" onclick="return false;">
            <div class="regist">
                <div class="regist_center">
                    <div class="regist_top">
                        <div class="left fl">会员注册</div>
                        <div class="clear"></div>
                        <div class="xian center"></div>
                    </div>
                    <div class="regist_main center">
                        <div class="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input class="shurukuang" type="text" id="username" name="username" placeholder="请输入你的手机号"/><span>请填写正确的手机号</span></div>
                        <div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="shurukuang"  id="password" type="password" name="password" placeholder="请输入你的密码"/><span>请输入6位以上字符</span></div>

                        <div class="username">确认密码:&nbsp;&nbsp;<input class="shurukuang" type="password" id="repassword" name="repassword" placeholder="请确认你的密码"/><span>两次密码要输入一致哦</span></div>
<%--                        <div class="username">手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<input class="shurukuang" type="text" name="tel" placeholder="请填写正确的手机号"/><span>填写下手机号吧，方便我们联系您！</span></div>--%>
                        <div class="username">
                            <div class="left fl">验&nbsp;&nbsp;证&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="yanzhengma" type="text" name="verifyCode" placeholder="请输入验证码"/></div>
                            <div class="right fl"><img src="./image/yanzhengma.jpg"></div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="regist_submit">
                        <input class="submit" type="submit"  onclick="register()" name="submit" value="立即注册" >
                    </div>

                </div>
            </div>
        </form>
    </body>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/swiper.min.js"></script>
    <script src="/js/regular.js"></script>
    <script src="/js/sweetalert.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>

    <script type="text/javascript">

        /**
         * 注册按钮调用方法
         */
        function register() {
            
            //检查是否输入正确
            var username = $("#username").val();
            
            if (!validPhoneNumber(username)){
                swal("请输入正确的登录名(即手机号)"),{
                    icon:"error"
                }
                return false;
            }
            var password = $("#password").val();
            if (!validPassword(password)) {
                swal("请输入正确的密码格式(6-20位字符和数字组合"),{
                    icon:"error"
                }
            }
            var repassword = $("#repassword").val();
            
            if (!validPassword(repassword)) {
                swal("请输入正确的密码格式(6-20位字符和数字组合"),{
                    icon:"error"
                }
            }

            var param = $("#registerForm").serialize();
            var url = "/register";

            //发送异步请求
            $.ajax({

                type:"POST",
                url:url,
                data:param,
                success:function (result) {

                    if (result.resultCode == 200) {
                        swal({
                            title:"注册成功！",
                            text:"是否跳转页面？",
                            icon:"success",
                            button:"true",
                            dangerMode:true,
                        }).then((flag) => {

                            if (flag) {
                                window.location.href = "/login";
                            }
                        }
                    )
                    } else {
                        swal(result.message,{
                            icon:"error"
                        });
                    }
                },
                error:function () {
                    swal("操作失败",{
                        icon:"error",
                    });
                }
            })
        }
        
    </script>
</html>