<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;

    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>
    <link rel="stylesheet" type="text/css" href="css/rigsht.css"/>
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <%--		<script type="text/javascript" src="js/user_rigsht.js" ></script>--%>
</head>
<body>
<div class="logo">
    <a href="#">夜视书城</a>
</div>

<form action="${pageContext.request.contextPath}/user/righst" method="post">
    <div class="center">
        <!--注册开始-->
        <div class="rigsht">
            <h2>夜视书城用户注册</h2>
            <hgroup>
                <c:if test="${usernameFlag == false}">
                    <h3>用户名格式错误</h3>
                </c:if>
                <c:if test="${userFlag == false}">
                    <h3>账号错误！</h3>
                </c:if>
                <c:if test="${passwordFlag == false}">
                    <h3>密码错误</h3>
                </c:if>
                <c:if test="${password2Flag == false}">
                    <h3>密码不一致</h3>
                </c:if>
                <c:if test="${emailFlag == false}">
                    <h3>邮箱格式错误</h3>
                </c:if>
                <c:if test="${userlFlag2 == false}">
                    <h3>账号已存在</h3>
                </c:if>
            </hgroup>


            <div class="rigsht_box">
                <!--required:不能为空，必须写-->
                <input type="text" required="required" id="username" name="username"/>
                <label>用户名</label>
                <%--						<span class="span1">用户名必须为2-12位字母/数字/中文</span>--%>
            </div>

            <div class="rigsht_box">
                <input type="text" required="required" id="user" name="user"/>
                <label>账号</label>
                <%--						<span class="span2">账号不能含非数字和首字符为0且账号长度为6至11位</span>--%>
            </div>

            <div class="rigsht_box">
                <input type="password" required="required" id="password" name="password"/>
                <label>密码</label>
                <%--						<span class="span3">密码不能为空，长度为6至16位且密码含有非法字符或没有以字母开头</span>--%>
            </div>

            <div class="rigsht_box">
                <input type="password" required="required" id="password2" name="password2"/>
                <label>确认密码</label>
                <%--						<span class="span4">两次密码输入不一致</span>--%>
            </div>

            <div class="rigsht_box">
                <input type="email" required="required" id="email" name="email"/>
                <label>邮箱</label>
                <%--						<span class="span5">邮箱格式错误，请输入正确邮箱</span>--%>
            </div>

            <%--					<a href="#" class="rigsht_a" onclick="torigsht()">注册</a>--%>
            <input type="submit" class="rigsht_a" value="注册">
        </div>
        <!--注册结束-->
    </div>
</form>


</body>
</html>
