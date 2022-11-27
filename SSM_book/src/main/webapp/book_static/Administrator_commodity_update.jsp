<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>商品修改</title>

    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;

    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>

    <link href="layui/css/layui.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>

</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>商品信息修改</legend>
</fieldset>
<%--${pageContext.request.contextPath}/admin/updatecommodity--%>
<form class="layui-form" action="" lay-filter="bookForm" method="post">

    <div class="layui-form-item" hidden>
        <label class="layui-form-label">商品id</label>
        <div class="layui-input-block">
            <input type="text" name="id"  lay-verify="required" lay-reqtext="不能为空" placeholder="请输入"
                   autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">作品名称</label>
        <div class="layui-input-block">
            <input type="text" name="bookname" id="bookname" lay-verify="required" lay-reqtext="不能为空" placeholder="请输入"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">作者</label>
        <div class="layui-input-block">
            <input type="text" name="bookauthor" id="bookauthor" lay-verify="required" lay-reqtext="不能为空"
                   placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">商品发布状态</label>
            <div class="layui-input-inline">
                <input type="text" name="bookstate" id="bookstate"  class="layui-input demo-phone">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">被收藏数</label>
            <div class="layui-input-inline">
                <input type="text" name="bookCollection" id="bookCollection" class="layui-input demo-phone">
            </div>
        </div>

    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="button" class="layui-btn" lay-submit="" lay-filter="demo1">
                立即提交
            </button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>


<script src="layui/layui.js"></script>

<script>
    layui.use(['form', 'util', 'laydate','table'], function () {
        var form = layui.form;
        var layer = layui.layer;
        var table = layui.table;
        var util = layui.util;
        var laydate = layui.laydate;

        var data = JSON.parse(localStorage.getItem("user"));
        // console.log(data)

        form.val("bookForm",{
            "id":data.id,
            "bookname":data.bookname,
            "bookauthor":data.bookauthor,
            "bookstate":data.bookstate,
            "bookCollection":data.bookCollection

        });

        //提交事件
        form.on('submit(demo1)', function(data){

            $.ajax({
                url: "${pageContext.request.contextPath}/admin/updatecommodity",
                data: data.field,
                type:"POST",
                success: function (data) {

                    if(data.code==200){
                        layer.msg("修改成功");

                    }else{
                        layer.msg("修改失败")
                    }
                },
                error: function (data) {
                    alert("错误")
                }
            })
            return false;
        });

    });


</script>

</body>
</html>