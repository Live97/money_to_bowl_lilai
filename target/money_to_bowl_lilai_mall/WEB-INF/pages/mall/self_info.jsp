<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="UTF-8">
        <meta name="author" content="order by dede58.com" />
        <title>商城-个人中心</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" type="text/css" href="/css/bootstrap-modal.css">
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
            <a href="">
                <div class="ad_top fl"></div>
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
                            <li><a href="##" style="color:#ff6700;font-weight:bold;">我的个人中心</a></li>
                            <li><a href="/order">我的订单</a></li>
                            <li><a href="/logout">退出登录</a></li>
                        </ul>
                    </div>
                </div>
                <div class="rtcont fr">
                    <div class="grzlbt ml40">我的资料
                            <a href="javascript:openUpdateModal();" style="float: right;margin-right: 100px; color: #1baeae;">更改个人信息</a>
                    </div>
                    <%--  使用el表达式渲染上去--%>
                    <div class="subgrzl ml40">
                        <span>昵称</span>
                        <span>${MallUser.user_nick_name}</span>
                    </div>
                    <div class="subgrzl ml40">
                        <span>手机号</span>
                        <span>${MallUser.login_name}</span>
                    </div>
                    <div class="subgrzl ml40">
                        <span>密码</span>
                        <span>************</span>
                    </div>
                    <div class="subgrzl ml40">
                        <span>个性签名</span>
                        <span>
                            <c:if test="${MallUser.introduce_sign == '' || MallUser.introduce_sign == null}">
                                无
                            </c:if>
                            <c:if test="${MallUser.introduce_sign != '' && MallUser.introduce_sign != null}">
                                ${MallUser.introduce_sign}
                            </c:if>
                        </span>
                    </div>
                    <div class="subgrzl ml40">
                        <span>收货地址</span>
                        <span>
                            <c:if test="${MallUser.address == '' || MallUser.address == null}">
                                无
                            </c:if>
                            <c:if test="${MallUser.address != '' && MallUser.address != null}">
                                ${MallUser.address}
                            </c:if>
                        </span>
                    </div>
                
                </div>
                <div class="clear"></div>
                
                <!-- Modal模态框 控制更改信息弹窗 -->
                <div class="modal fade" id="personalInfoModal" tabindex="-1" role="dialog" aria-labelledby="personalInfoModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true"></span></button>
                                <h4 class="modal-title" id="personalInfoModalLabel">个人信息修改</h4>
                            </div>
                            <div class="modal-body">
                                <form id="personalInfoForm">
                                    <div class="form-group">
                                        <label for="nickName" class="control-label">昵称:</label>
                                        <input type="hidden" id="userId" value="${MallUser.user_id}">
                                        <input type="text" class="form-control" id="nickName" name="nickName"
                                               placeholder="请输入昵称" value="${MallUser.user_nick_name}"
                                               required="true">
                                    </div>
                                    <div class="form-group">
                                        <label for="introduceSign" class="control-label">个性签名:</label>
                                        <input type="text" class="form-control" id="introduceSign" name="introduceSign"
                                               placeholder="请输入个性签名" value="${MallUser.introduce_sign}"
                                               required="true">
                                    </div>
                                    <div class="form-group">
                                        <label for="address" class="control-label">收货信息:</label>
                                        <input type="text" class="form-control" id="address" name="address"
                                               placeholder="请输入收货信息" value="${MallUser.address}"
                                               required="true">
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary" id="saveButton">确认</button>
                            </div>
                        </div>
                    </div>
                </div>
               
            </div>
        </div>
        <!-- self_info -->
        
        
        <footer class="mt20 center">
            <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
            <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
            <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
        </footer>
    </body>
    
<%--    引入js库,注意jquery必须放在前面，因为bootstrap存在依赖于jQuery--%>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/bootstrap3.js"></script>
    <script src="/js/sweetalert.min.js"></script>
    <script src="/js/swiper.min.js"></script>
    <script src="/js/regular.js"></script>
    <script src="/js/index.js"></script>
    
    <script type="text/javascript">
    
        function openUpdateModal() {
            $('#personalInfoModal').modal('show');
        }
        $("#saveButton").click(function () {
            
            var address = $("#address").val();
            if (address.trim().length < 10) {
                swal("请输入正确的收获地址",{
                    icon:"error"
                });
                return;
            }
            var nickName = $("#nickName").val();
            if (nickName.trim().length < 2) {
                swal("请输入正确的昵称",{
                    icon:"error"
                });
                return;
            }
            var introduceSign = $("#introduceSign").val();
            if (introduceSign.trim().length > 30) {
                swal("请输入正确的个性签名",{
                    icon:"error"
                });
                return;
            }
            
            //获取到当前访问的用户
            var userId = $("#userId").val();
            var data = {
                
                "user_id":userId,
                "address":address,
                "introduce_sign":introduceSign,
                "user_nick_name":nickName
            };
            
            $.ajax({
                
                type:"POST",
                url:"/personal/updateInfo",
                contentType:"application/json",
                data:JSON.stringify(data),
                success:function (result) {
                    
                    if (result.resultCode == 200) {
                        $("#personalInfoModal").modal('hide');
                        window.location.reload();
                    } else {
                        $("#personalInfoModal").modal('hide');
                        alert(result.message);
                    }
                },
                error:function () {
                    alert("操作失败!");
                    alert(JSON.stringify(data));
                }
                
            })
        })
    </script>
</html>