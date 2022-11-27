<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;

    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>

    <link rel="stylesheet" type="text/css" href="css/index.css"/>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">

    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script src="layui/layui.js"></script>

    <script type="text/javascript" src="js/index.js"></script>

</head>
<body>
<%--顶部导航栏开始--%>
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
                    <input type="search" name="search" id="search" class="search_field" placeholder="搜索你想要的书籍名"/>

                    <img id="tosearch" src="img/search.png" style="float: right;">

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
<%--顶部导航结束--%>

<!--热门商品展示开始-->
<div class="center">
    <div class="center_bookshow">
        <h1>热门商品展示</h1>
        <!--商品展示轮番图-->
        <div class="layui-carousel" id="test1" style="height: 690px;">
            <div carousel-item>
                <c:forEach items="${nowBooks}" var="nowTopbooks">
                    <c:choose>
                        <c:when test="${nowTopbooks.bookCollection >= 10}">
                            <div>
                                <div class="book_img">
                                    <h2>《${nowTopbooks.bookname}》</h2>
                                    <img src="${nowTopbooks.imgUrl}"/>
                                    <div>
                                        <ul>
                                            <li>
                                                <a href="${pageContext.request.contextPath}/index/bookparticulars.do?id=${nowTopbooks.id}">
                                                    <span id="index_particuar">详情</span>
                                                </a>
                                            </li>
                                            <li>作者：${nowTopbooks.bookauthor}</li>
                                        </ul>
                                    </div>
                                </div>
                                <!--书中内容的一段话加一张图片-->
                                <div class="book_discourse">
                                    <h2>摘要</h2>
                                    <img src="${nowTopbooks.imgUrl2}"/>
                                    <p>${nowTopbooks.booksynopsis}</p>
                                </div>
                            </div>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </div>
        </div>

    </div>


</div>
<!--热门商品展示结束-->


<!--尾部所有商品展示开始-->
<div class="below">
    <div class="books_below">
        <h2>商品展示</h2>
<%--        <ul>--%>
<%--            <c:forEach items="${nowBooks}" var="nowbooks">--%>
<%--                <li>--%>
<%--                    <img src="${nowbooks.imgUrl}" width="250px" height="300px"/><br>--%>
<%--                    <span>《${nowbooks.bookname}》</span><br>--%>
<%--                    <a href="${pageContext.request.contextPath}/index/bookparticulars.do?id=${nowbooks.id}">详情</a>--%>
<%--                </li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
        <div class="layui-row layui-col-space1">
            <c:forEach items="${nowBooks}" var="nowbooks">
                <div class="layui-col-md3">
                    <div class="grid-demo grid-demo-bg1" >
                        <li class="books_belowli">
                            <img src="${nowbooks.imgUrl}" /><br>
                            <span>《${nowbooks.bookname}》</span><br>
                            <a href="${pageContext.request.contextPath}/index/bookparticulars.do?id=${nowbooks.id}">详情</a>
                        </li>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>
</div>
<!--尾部所有商品展示结束-->


<script>
    //轮番图
    layui.use('carousel', function () {
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1'
            , width: '100%' //设置容器宽度
            , height: '690px'
            , arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });

    //搜索
    layui.use('layer', function () {
        var layer = layui.layer;
        var tosearch = document.getElementById("tosearch");
        tosearch.onclick = function () {
            var user = $(".user_menu h3").text();
            // alert(user)
            var search = $("#search").val();
            if (user != "") {
                // layer.msg("欢迎")
                if (search != "") {
                    $.ajax({
                        url: "../index/usersearch",
                        type: "post",
                        data: {
                            search: search
                        },
                        success: function (data) {
                            // alert("成功")
                            window.location.href = "http://localhost:8080/ssm_books/book_static/booksearch.jsp";
                        },
                        error: function (data) {
                            alert("错误")
                        }
                    });
                } else {
                    // alert("搜索不能为空")
                    layer.msg("搜索不能为空")
                }
            } else {
                // alert("没有用户登录")
                layer.msg("没有用户登录")
            }
        }

    });

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
