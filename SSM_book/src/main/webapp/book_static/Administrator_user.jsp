<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>管理员页面</title>
    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;
    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="js/jquery-3.6.0.min.js"></script>
    <script rel="stylesheet" type="text/javascript" src="js/Administrator_user.js"></script>
</head>
<body>

<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">夜视书城后台</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>

            <li class=" layui-hide-xs">欢迎管理员登录</li>

        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="${admin_nowUser.userimg}" class="layui-nav-img">
                    ${admin_nowUser.username}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href=""></a></dd>
                    <dd><a href=""></a></dd>
                    <dd><a href="${pageContext.request.contextPath}/user/out">退出登录</a></dd>
                </dl>
            </li>

        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
<%--                    onclick="admin_user()"--%>
                    <a class="Administrator_usermanagement" href="#">用户信息管理</a>
                </li>
                <li class="layui-nav-item">
<%--                    onclick="admin_commodity()"--%>
                    <a href="#" class="Administrator_commodity">商品信息管理</a>
                </li>
                <li class="layui-nav-item" onclick="admin_type()">
                    <a href="#" class="Administrator_Goodsreleased">商品发布</a>
                </li>
                <li class="layui-nav-item">
                    <a href="#" class="Administrator_Addtype" onclick="admin_addtype()">添加分类</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <iframe id="myiframe" class="myiframe" style="width: 100%;height: 87vh;border: none"></iframe>
        </div>
    </div>

</div>
<script src="layui/layui.js"></script>
<script>
    //JS
    layui.use(['element', 'layer', 'util'], function () {
        var element = layui.element
            , layer = layui.layer
            , util = layui.util
            , $ = layui.$;

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function (othis) {
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            , menuRight: function () {
                layer.open({
                    type: 1
                    , content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    , area: ['260px', '100%']
                    , offset: 'rt' //右上角
                    , anim: 5
                    , shadeClose: true
                });
            }
        });

    });
</script>

</body>
</html>