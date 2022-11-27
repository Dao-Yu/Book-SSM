<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;
    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>
    <link rel="stylesheet" type="text/css" href="css/user.css"/>
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>

    <script type="text/javascript" src="js/user.js"></script>
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
</head>
<body>

<head>
    <!--顶部导航栏-->
    <div class="navigationbar">
        <nav>
            <ul>
                <li>
                    <a href="${pageContext.request.contextPath}/book_static/index.jsp" class="heade_log">
                        <h1>夜视书城</h1>
                    </a>
                </li>

                <li><a href="${pageContext.request.contextPath}/book_static/index.jsp">首业</a></li>
                <li><a href="${pageContext.request.contextPath}/index/bookstackrooms">书库</a></li>
                <li><a href="${pageContext.request.contextPath}/book_static/bookcircle.jsp" onclick="showbookcircle()">书圈</a></li>

                <!--<li><a href="#">排行榜</a></li>-->

                <li class="search_li">
                    <span>欢迎登录，尊敬的${nowUser.username}用户</span>
                </li>

                <div style="float: right">
                    <li id="user_li_login">
                        <a href="${pageContext.request.contextPath}/book_static/login.jsp" class="heade_login"
                           name="login">登录</a>
                        |&nbsp;|
                        <a href="${pageContext.request.contextPath}/book_static/rigsht.jsp" class="heade_right"
                           name="rigsht">注册</a>
                    </li>
                </div>

                <!--用户头像下拉菜单栏开始-->

                <c:choose>
                    <c:when test="${nowUser!=null}">
                        <div style="float: right">
                            <li id="user_li">
                                <div class="user_action">
                                    <div class="user_profile" onclick="menuToggle()">
                                        <img src="${nowUser.userimg}"/>
                                    </div>

                                    <div class="user_menu">
                                        <h3>${nowUser.username}</h3>
                                        <ul>
                                            <li>
                                                <a href="${pageContext.request.contextPath}/book_static/user.jsp">个人中心</a>
                                            </li>
                                            <li><a href="${pageContext.request.contextPath}/user/out">退出登录</a></li>
                                        </ul>
                                    </div>

                                </div>
                            </li>
                        </div>
                    </c:when>
                </c:choose>


                <!--用户头像下拉菜单栏结束-->


            </ul>
        </nav>
    </div>
</head>

<!--中间部分开始-->
<div class="center">
    <div class="center_div">
        <!--用户选择类开始-->
        <div class="center_user_option">
            <h1>个人中心</h1>
            <ul>
                <li>
                    <a href="#">
                        <img src="${nowUser.userimg}"/>
                    </a>
                    <h2>${nowUser.username}</h2>
                </li>


                <li><a href="#" class="user_information_myiframe" onclick="showOneUser()">资料</a></li>
                <li><a href="#" class="user_userbookcollect_myiframe" onclick="usercollect()">收藏</a></li>
                <li><span class="user_shopping_myiframe" onclick="userbookshopping()">购物车</span></li>
                <!--<li><a href="#">历史记录</a></li>-->
            </ul>
        </div>
        <!--用户选择类结束-->

        <!--用户选择详情类开始-->
        <div class="center_user_display">
            <iframe id="myiframe"></iframe>
        </div>
        <!--用户选择详情类结束-->

    </div>
</div>
<!--中间部分结束-->

<script>

    //点击资料事件
    function showOneUser() {
        $.ajax({
            url: "../user/userShow",
            type: "post",
            success: function (data) {
                // alert("成功")

            },
            error: function (data) {
                alert("错误")
            }
        })
    }

    //点击收藏事件
    function usercollect() {
        // alert(111)
        $.ajax({
            url: "../user/userboookcollect",
            type: "post",
            success: function (data) {
                // alert("成功")

            },
            error: function (data) {
                alert("错误")
            }
        })
    }

    //点击购物车事件
    function userbookshopping() {
        $.ajax({
            url: "../user/userbookshopping",
            type: "post",
            success: function (data) {

            },
            error: function (data) {
                layer.msg("错误")
            }
        })
    }

    //点击书圈事件
    function showbookcircle() {
        $.ajax({
            url: "../user/showbookcircle",
            type: "post",
            success: function (data) {
                // alert(data)
                console.log(data)
            },
            error: function (data) {
                alert("错误")
            }
        });
    }

</script>


</body>
</html>
