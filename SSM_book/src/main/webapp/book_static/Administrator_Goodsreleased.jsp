<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品发布</title>

    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;

    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>

    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="js/Administrator_Goodsreleased.js"></script>

    <link href="layui/css/layui.css" rel="stylesheet">


</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>商品发布</legend>
</fieldset>

<form class="layui-form" action="${pageContext.request.contextPath}/admin/Goodsreleased" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">作品名称</label>
        <div class="layui-input-block">
            <input type="text" name="bookname" id="bookname" lay-verify="required" lay-reqtext="用户名是必填项，岂能为空？"
                   placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">作者</label>
        <div class="layui-input-block">
            <input type="text" name="bookauthor" id="bookauthor" lay-verify="required" lay-reqtext="用户名是必填项，岂能为空？"
                   placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">库存</label>
            <div class="layui-input-inline">
                <input type="text" name="bookamount" value="1" class="layui-input demo-phone">
            </div>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">价格</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" id="bookprice" name="bookprice" placeholder="￥" autocomplete="off"
                       class="layui-input">
            </div>

        </div>
    </div>

    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">类别选择</label>
            <div class="layui-input-inline">
                <select id="booktype" name="booktype" lay-verify="required" lay-search="">
                    <c:forEach items="${booktypes}" var="booktype">
                        <option>${booktype.type}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">封面</label>
            <div class="layui-input-inline">

                <input type="file" id="photo">
                <span id="uploadspan"></span>
                <input type="hidden" name="imgUrl" id="imgUrl" value="">

            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">海报</label>
            <div class="layui-input-inline">

                <input type="file" id="photo2">


                <span id="uploadspan2"></span>
                <input type="hidden" name="imgUrl2" id="imgUrl2" value="">

                <input type="button" value="优先点击此处上传图片" id="upload2" onclick="uploadimg()">


            </div>
        </div>
    </div>


    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">作品简介</label>
        <div class="layui-input-block">
            <textarea id="booksynopsis" name="booksynopsis" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


<script src="layui/layui.js"></script>

<script>
    layui.use(['form', 'util', 'laydate'], function () {
        var form = layui.form;
        var layer = layui.layer;
        var util = layui.util;
        var laydate = layui.laydate;


    });
</script>

</body>
</html>