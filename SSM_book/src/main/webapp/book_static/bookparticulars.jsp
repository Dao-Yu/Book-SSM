<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>书本详情页</title>
    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;

    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>
    <link rel="stylesheet" type="text/css" href="css/bookparti.css"/>
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="js/bookparti.js"></script>

    <link rel="stylesheet" href="layui/css/layui.css" media="all">

    <script src="layui/layui.js"></script>

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
                <li><a href="${pageContext.request.contextPath}/book_static/stackroom.jsp">书库</a></li>
                <li><a href="${pageContext.request.contextPath}/book_static/bookcircle.jsp" onclick="showbookcircle()">书圈</a></li>

                <!--<li><a href="#">排行榜</a></li>-->

                <li class="search_li">
                    <span>这是《${thisbook.bookname}》的详情页面哦</span>
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


<div class="center">

    <div class="center_bookparticulars">
        <h2>书本详情</h2>
        <!--书籍图片-->
        <div class="book_img">
            <img src="${thisbook.imgUrl}"/>
            <div>
                <ul>
                    <h3>${thisbook.bookname}</h3>

                    <!--<li><a href="#">详情</a></li>-->
                    <li onclick="tobookcollect()">
                        <span id="bookcollect">收藏</span>
                    </li>

                    <li>价格：<span>￥${thisbook.bookprice}</span></li>
                    <li>类别：<span>${thisbook.booktype}</span></li>
                    <li>作者：<span>${thisbook.bookauthor}</span></li>
                    <li>上架日期：<span>${thisbook.booktime}</span></li>
                    <li onclick="tobookshopping()">
                        <span>加入购物车</span>
                    </li>

                </ul>
            </div>
        </div>


        <div class="book_comment">
            <h2>评论</h2>
            <!--用户选择详情类开始-->
            <div class="book_comment_iframe">
                <iframe id="myiframe" src="${pageContext.request.contextPath}/book_static/bookcomment.jsp"></iframe>
            </div>
            <!--用户选择详情类结束-->
        </div>

    </div>

</div>

<script>
    /*用户点击收藏事件*/
    function tobookcollect() {
        // alert(1111)
        // alert($("#bookcollect").text())
        $.ajax({
            url: "../index/bookcollect",
            type: "post",
            success: function (data) {
                // alert(data)
                if (data == "true") {
                    $("#bookcollect").text('已收藏');
                    layer.msg('收藏成功');
                }
                if (data == "user_true") {
                    $("#bookcollect").text('已收藏');
                    layer.msg('已收藏，请勿重复收藏');
                }
                if (data == 'false') {
                    layer.msg('请先登录！');
                }
            },
            error: function (data) {
                layer.msg("请先登录！");
            }
        });
    }

    /*用户点击加入购物车事件*/
    function tobookshopping() {
        // layer.msg("已加入购物车")
        //查看是否有用户登录
        var user = $(".user_menu h3").text();

        if (user != "") {
            $.ajax({
                url: "../index/bookshopping",
                type: "post",
                success: function (data) {
                    if (data == "true") {
                        layer.msg("已加入购物车");
                    }
                    if (data == "book_true") {
                        layer.msg("已加入购物车，请勿重复添加")
                    }
                },
                error: function (data) {
                    layer.msg("错误");
                }
            })
        } else {
            layer.msg("请先登录！");
        }

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
