<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户购物车</title>
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="css/user_bookshooping.css">

    <script src="js/jquery-3.6.0.min.js"></script>
    <script src="js/user_bookshooping.js"></script>
</head>
<body>

<div class="div_box">
    <table id="cartTable">
        <thead>
        <tr>
            <th>
                <input type="checkbox" class="checkbox-all checkbox" style="height: 15px;width: 15px">&nbsp;&nbsp;全选
            </th>
            <th>商品图片</th>
            <th>商品名称</th>
            <th>商品单价</th>
            <th>数量</th>
            <th>小记</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="tbody">
        <c:forEach items="${ShoppingBooks}" var="ShoppingBooks">
            <tr>
                <td>
                    <input type="checkbox" class="checkbox-one checkbox" style="width: 23px;height: 23px">
                </td>
                <td>
                    <img style="width: 120px;height: 150px" src="${ShoppingBooks.imgUrl}">
                </td>
                <td>${ShoppingBooks.bookname}</td>
                <td style="color: red;font-size: 20px">${ShoppingBooks.bookprice}</td>
                <td>
                    <div class="layui-btn-group">
                        <button type="button" class="layui-btn layui-btn-primary layui-btn-sm reduce">-</button>
                        <input type="text" value="1" class="layui-btn layui-btn-primary layui-btn-sm">
                        <button type="button" class="layui-btn layui-btn-primary layui-btn-sm add">+</button>
                    </div>
                </td>
                <td class="price"></td>
                <td>
                    <button type="button" class="layui-btn layui-btn-danger"
                            onclick="delete_book('${ShoppingBooks.id}')">删除
                    </button>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

<div class="div_box2">
    <div class="bookcount">已选商品数：<span id="selectedTotal">0</span>件</div>
    <div class="count">合计：<span id="pricecount">00.00</span></div>
    <div class="close">
        <button type="button" class="layui-btn layui-btn-warm ">去结算</button>
    </div>
</div>

<script src="layui/layui.js"></script>
<script>
    function delete_book(bookid) {
        layer.open({
            content: '确认删除吗？',
            yes: function (index) {
                $.ajax({
                    url: "../user/deletebookshopping",
                    type: "post",
                    data: {
                        bookid: bookid
                    },
                    success: function (data) {
                        layer.close(index);
                        location.reload();
                    },
                    error: function (data) {
                        alert("失败")
                    }
                });
                layer.msg("删除成功")
            }
        });
    }
</script>
</body>
</html>

