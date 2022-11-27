<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>书库</title>

    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;

    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>


    <link rel="stylesheet" type="text/css" href="css/stackroom.css"/>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">

    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>

    <script type="text/javascript" src="js/index.js"></script>


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
						<span>
							<h3>“欢迎来到夜视书城中的图书馆”</h3>
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

<!--分类部分开始-->
<div class="center">
    <div class="center_classify">
        <ul>
            <li>分类:</li>
            <%--现阶段只能少分类，不然页面样式会乱，后续改进--%>
            <c:forEach items="${index_booktype}" var="index_booktype">
                <li>
                    <a href="#" class="fas">${index_booktype.type}</a>
                </li>
            </c:forEach>
        </ul>

    </div>
</div>
<!--分类部分结束-->

<!--书库最下面的部分-->
<div class="finally">
    <div class="stackroom_finally">
        <ul>
            <li><a href="#">最新</a></li>
            <li><a href="#">最热</a></li>
            <li><a href="#">字数</a></li>
        </ul>
        <hr>
        <!--书本展示-->
        <div class="books_below_stackroom">
            <div class="layui-row layui-col-space1">
                <c:forEach items="${nowBooks}" var="nowbooks">
                    <div class="layui-col-md3">
                        <div class="grid-demo grid-demo-bg1" >
                            <li class="books_below_stackroomli">
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
</div>

<script>
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
