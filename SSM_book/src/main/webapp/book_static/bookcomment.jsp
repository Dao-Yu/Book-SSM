<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户评论</title>
    <link rel="stylesheet" type="text/css" href="css/bookcomment.css"/>

    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>

    <script src="layui/layui.js"></script>
</head>
<body>
<c:forEach items="${thisbookcommentuser}" var="thisbookcommentuser">
    <c:forEach items="${thisbookcommentuser.comment}" var="bookcomments">
        <div class="book_comment">
            <!--展示评论-->
            <div class="book_comment_div">
                <!--头像-->
                <div class="book_comment_div_img">
                    <img src="${thisbookcommentuser.userimg}"/>
                </div>
                <!--时间和用户名-->
                <div class="book_comment_div_time">
                        <%--用户名--%>
                    <span>${thisbookcommentuser.username}</span><br>
                        <%--时间--%>
                    <span>${bookcomments.commenttime}</span>

                    <!--评论-->
                    <div class="book_comment_div_comment">
                        <span>${bookcomments.comment}</span>
                    </div>

                </div>

            </div>

        </div>
    </c:forEach>
</c:forEach>


<!--发表评论类-->
<div class="book_comment_speak_div">
    <!--发表评论-->
    <div class="book_comment_speak">
        <h3>发表评论</h3>
        <textarea id="comment"></textarea>
        <div>
            <button onclick="toinbookcomment()">点击发表</button>
        </div>
    </div>
</div>


<script>
    //发表评论
    function toinbookcomment() {

        var comment = $("#comment").val();
        // alert(comment)
        if (comment != "") {
            layer.msg("进入")
            $.ajax({
                url: "../index/boookcomment",
                type: "post",
                data: {
                    comment: comment
                },
                success: function (data) {
                    // alert(data)
                    if (data == 'false') {
                        layer.msg("登录才能发表评论")
                    }
                    if (data == 'true') {
                        $("#comment").text(" ")
                        layer.msg("发布成功")
                        location.reload();
                    }
                },
                error: function (data) {
                    alert("失败")
                }
            })
        } else {
            layer.msg("不能发布空评论哦")
        }
    }
</script>


</body>
</html>
