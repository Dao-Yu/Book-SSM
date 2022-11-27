<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <%--		<meta http-equiv="refresh" content="20">--%>
    <title>收藏</title>

    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;
    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>

    <link rel="stylesheet" type="text/css" href="css/user_bookcollect.css"/>

    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>

</head>
<body>
<div class="heade_userbookcollect01">


    <div class="user_collect_sentence">
        <h2>收藏的书</h2>
    </div>

</div>
<div class="heade_userbookcollect01">
    <div class="user_collect_sentence" id="bookcoller01">
        <span class="user_collect_sentence_span">暂时没有收藏</span>
    </div>
</div>

<c:forEach items="${Userbooks}" var="Userbooks">
    <div class="heade_userbookcollect02">
        <!--收藏的书-->
        <div class="user_collect_books" id="bookcoller02">
            <from>
                <table>
                    <tr>
                        <td rowspan="7">
                            <a href="#"><img style="width: 120px;height: 150px;" src="${Userbooks.imgUrl}"/></a>
                                <%--									<p id="bookname">${Userbooks.bookname}</p>--%>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <span>书名：</span><span id="bookname">${Userbooks.bookname}</span>
                        </td>
                    </tr>

                    <tr></tr>

                    <tr>
                        <td>
                            <span>作者：</span><span>${Userbooks.bookauthor}</span>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <span>库存：</span><span>${Userbooks.bookamount}</span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>价格：</span><span>${Userbooks.bookprice}</span>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <span><a href="#" onclick="deleteuserbookcollect('${Userbooks.id}')">取消收藏</a></span>
                        </td>
                    </tr>

                </table>
            </from>
        </div>

    </div>
</c:forEach>

<script src="layui/layui.js"></script>
<script>
    $(window).ready(function () {
        $("#bookcoller01").hide();
        var bookname = $("#bookname").text();
        // alert(bookname);
        if (bookname != "") {

        } else {
            $("#bookcoller01").show();
            $("#bookcoller02").hide();
        }
    });

    //取消收藏
    function deleteuserbookcollect(bookid) {
        // alert(bookid)

        $.ajax({
            url: "../user/deleteuserboookcollect",
            type: "post",
            data: {
                bookid: bookid
            },
            success: function (data) {
                location.reload();
            },
            error: function () {
                alert("错误")
            }
        });
    }
</script>

</body>
</html>
