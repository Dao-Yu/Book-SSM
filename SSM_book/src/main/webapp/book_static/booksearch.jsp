<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>搜索</title>
    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;

    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>
    <link rel="stylesheet" type="text/css" href="css/booksearchs.css"/>
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="js/index.js"></script>

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
                    <%--						<input type="search" name="search" class="search_field" placeholder="搜索你想要的内容" />--%>
                    <%--						<a href="${pageContext.request.contextPath}/book_static/booksearch.jsp" style="float: right;">--%>
                    <%--							<img src="img/search.png">--%>
                    <%--						</a>--%>
                    <span>
							<h3>“夜视搜书，输入正确的书名，搜索更准确”</h3>
						</span>
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
        <!--搜索框-->
        <div class="center_search">
            <input type="search" id="bookname"/>
            <button onclick="tobooksearch()">搜索</button>
        </div>

        <!--结果-->
        <div class="center_result">
            <ul>
                <li><a href="#">综合排序</a></li>
                <li><a href="#">最新发布</a></li>
                <li><a href="#">最新发布</a></li>
                <li><a href="#">最多点击</a></li>
            </ul>

            <div class="books_below">
                <ul>
                    <c:forEach items="${selectbookOnbooknames}" var="selectbookOnbookname">
                        <li>
                            <img src="${selectbookOnbookname.imgUrl}" width="250px" height="300px"/><br>
                            <span>书名：${selectbookOnbookname.bookname}</span><br>
                            <span>作者：${selectbookOnbookname.bookauthor}</span><br>
                            <a href="${pageContext.request.contextPath}/index/bookparticulars.do?id=${selectbookOnbookname.id}">详情</a>
                        </li>
                    </c:forEach>

                </ul>
            </div>

        </div>
    </div>

</div>
<!--中间部分结束-->

<%--<script src="js/layui.js"></script>--%>
<script>
    function tobooksearch() {
        var search = $("#bookname").val();
        // alert(bookname)
        if (search != "") {
            $.ajax({
                url: "../index/usersearch",
                type: "post",
                data: {
                    search: search
                },
                success: function (data) {
                    // alert("成功")
                    location.reload();
                },
                error: function (data) {
                    alert("错误")
                }
            });
        } else {
            layer.msg("请输入要搜索的内容")
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
