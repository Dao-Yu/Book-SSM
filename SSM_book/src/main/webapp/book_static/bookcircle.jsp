<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>书圈</title>
    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;

    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>
    <link rel="stylesheet" type="text/css" href="css/bookcircles.css"/>
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="js/index.js"></script>

    <link rel="stylesheet" href="layui/css/layui.css" media="all">
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
							<h3>书圈，这是一个书友互相种草的地方</h3>
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


<!--书圈动态个人信息-->
<div class="bookcircle_user">
    <div class="bookcircle_user_div" id="bookcircle_user_div">
        <!--头像-->
        <!--用户名-->
        <!--个性签名-->
        <table>
            <tr>
                <td rowspan="2">
                    <img src="${nowUser.userimg}"/>
                </td>
                <td>
                    <h2>${nowUser.username}</h2>
                </td>
            </tr>
            <tr>
                <td>
                    <h3>个性签名：</h3>
                    <span>${UserSignature.signature}</span>
                </td>
            </tr>
        </table>

        <div class="bookcircle_addimg">
            <a href="${pageContext.request.contextPath}/book_static/user_dynamicissue.jsp">
                <button type="button" class="layui-btn layui-btn-primary layui-btn-radius">添加动态</button>
            </a>
        </div>

    </div>
</div>

<!--书圈全部动态-->
<c:forEach items="${UserDynamicissue}" var="UserDynamicissue">
    <c:forEach items="${UserDynamicissue.dynamicissueEutityList}" var="User_dynamicissues">
        <div class="bookcircle_all">
            <div class="bookcircle_all_div">
                <!--头像、用户名、发布时间-->
                <div class="bookcircle_all_div_user">
                    <table>
                        <tr>
                            <td rowspan="2">
                                <a href="#"><img src="${UserDynamicissue.userimg}"></a>
                            </td>
                            <td>
                                <h3>${UserDynamicissue.username}</h3>
                            </td>
                        </tr>
                        <tr>
                            <td>${User_dynamicissues.dynamictime}</td>
                        </tr>
                    </table>
                </div>

                <!--用户发布的图片-->
                <div class="bookcircle_all_div_imgs">
                    <span>${User_dynamicissues.dynamictype}</span>
                    <ul>
                        <li>
                            <img src="${User_dynamicissues.dynamicimage}"/>
                        </li>
                    </ul>
                </div>

                <div class="bookbox">
                    <div class="bookbox2">
                        <div class="like">
                            <button style="border: none;background-color: white;cursor: pointer;">
                                <img src="img/dian1.png" style="width: 25px">
                            </button>
                        </div>
                    </div>

                    <div class="bookbox2">
                        <div class="comment">
                            <button style="border: none;background-color: white;cursor: pointer;">
                                <img src="img/pinglun.png" style="width: 25px">
                            </button>
                        </div>
                    </div>

                    <div class="bookbox2">
                        <div class="share">
                            <button style="border: none;background-color: white;cursor: pointer;">
                                <img src="img/fengxian.png" style="width: 25px">
                            </button>
                        </div>
                    </div>

                </div>

                <!--评论展示类-->
                <!--        <div class="book_comment">-->
                <!--            &lt;!&ndash;展示评论&ndash;&gt;-->
                <!--            <div class="book_comment_div">-->
                <!--                &lt;!&ndash;头像&ndash;&gt;-->
                <!--                <div class="book_comment_div_img">-->
                <!--                    <img src="img/user_head.jpeg"/>-->
                <!--                </div>-->
                <!--                &lt;!&ndash;时间和用户名&ndash;&gt;-->
                <!--                <div class="book_comment_div_time">-->
                <!--                    <span>云边有个小酒馆</span><br>-->
                <!--                    <span>2022-06-28</span>-->

                <!--                    &lt;!&ndash;评论&ndash;&gt;-->
                <!--                    <div class="book_comment_div_comment">-->
                <!--                        <span>这是一本好书</span>-->
                <!--                    </div>-->

                <!--                </div>-->

                <!--            </div>-->

                <!--        </div>-->


            </div>

        </div>
    </c:forEach>
</c:forEach>


<script>
    /*没有用户登录的状态时个人信息隐藏*/
    $(window).ready(function () {
        $("#bookcircle_user_div").hide();
        var user = $(".user_menu h3").text()
        if (user != "") {
            $("#bookcircle_user_div").show();
        } else {
            $("#bookcircle_user_div").hide();
        }
    });

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
