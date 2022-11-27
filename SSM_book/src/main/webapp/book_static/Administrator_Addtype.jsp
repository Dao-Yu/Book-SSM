<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加分类</title>
    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;
    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>

    <script src="js/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/Administrator_Addtype.css">
    <link rel="stylesheet" href="layui/css/layui.css">

    <script src="layui/layui.js"></script>

</head>
<body>
<div class="table_box">
    <table>
        <thead>
        <tr>
            <th>类别</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${Allbooktype}" var="allbooktypes">
            <tr>
                <td>${allbooktypes.type}</td>
                <td>
                    <button type="button" class="layui-btn layui-btn-danger layui-btn-radius" onclick="deletetype('${allbooktypes.id}')">删除</button>
<%--                    <button onclick="deletetype('${allbooktypes.id}')">删除</button>--%>
                </td>
            </tr>
        </c:forEach>

        <tr class="inupttr">
            <td>
                添加分类
                <input type="text" class="inputtext" id="type">
            </td>
            <td>
                <button type="button" class="layui-btn layui-btn-radius" onclick="toinbooktype()">提交</button>
<%--                <button onclick="toinbooktype()">提交</button>--%>
            </td>

        </tr>
        </tbody>
    </table>
</div>
<script>
    //新增类别
    function toinbooktype() {
        var type = $("#type").val();
        if (type != "") {
            $.ajax({
                url: "../admin/addtype",
                type: "post",
                data: {
                    type: type
                },
                success: function (data) {
                    layer.msg("添加成功")
                    location.reload()
                },
                error: function (data) {
                    layer.msg("添加失败")
                }
            })
        } else {
            layer.msg("新增类别不能为空")
        }
    }

    //删除类别
    function deletetype(id) {
        // alert(id)
        layer.open({
            content: "确认删除吗？",
            yes: function (index) {
                $.ajax({
                    url: "../admin/deletetype",
                    type: "post",
                    data: {
                        id: id
                    },
                    success: function (data) {
                        // alert("wdnmd")
                        // window.opener.location.href= window.opener.location.href;
                        layer.close(index);
                        location.reload();
                    },
                    error: function (data) {
                        layer.msg("删除失败")
                    }
                });
            }
        })
    }
</script>
</body>
</html>
