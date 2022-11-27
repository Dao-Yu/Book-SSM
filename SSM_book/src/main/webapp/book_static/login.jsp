<%@ page import="com.feng.entity.UserEntity" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;

    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <%--		<script type="text/javascript" src="js/user_login.js" ></script>--%>
</head>
<body>
<div class="logo">
    <a href="#">夜视书城</a>
</div>


<!--中间部分开始-->
<%--		${pageContext.request.contextPath}--%>
<%--用户登录--%>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    <div class="center">
        <div class="login">

            <!--错误提示-->

            <hgroup>
                <h2>用户登录</h2>
                <c:if test="${userFlag == false}">
                    <h3>账号错误！</h3>
                </c:if>
                <c:if test="${passwordFlag == false}">
                    <h3>密码错误</h3>
                </c:if>
            </hgroup>


            <div class="login_box">
                <!--required:不能为空，必须写-->
                <input type="text" required="required" id="user" name="user"/>
                <label>账号</label>
                <%--						<span class="span1">账号不能为空且账号不能含非数字和首字符为0，长度为5至12位</span>--%>
            </div>

            <div class="login_box">
                <input type="password" required="required" id="password" name="password"/>
                <label>密码</label>
                <%--						<span class="span2">密码含有非法字符或没有以字母开头，长度为6至18位</span>--%>
            </div>

            <!--					<button type="submit" class="login_a" onclick="tologin()">登录</button>-->
            <!--					<a href="#" class="login_a" onclick="tologin()">登录</a>-->
            <input type="submit" class="login_a" value="登录">

            <a href="${pageContext.request.contextPath}/book_static/rigsht.jsp" class="rigsht_a">没有账户，可点击这里注册</a>

        </div>
    </div>
</form>

<!--中间部分结束-->


</body>
</html>
