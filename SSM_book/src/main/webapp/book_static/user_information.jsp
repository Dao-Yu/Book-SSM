<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户资料</title>
    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;

    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>

    <link rel="stylesheet" type="text/css" href="css/userinformation.css"/>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">

    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script src="layui/layui.js"></script>
</head>
<body>
<div class="card-container">

    <div class="card-head">
        <img src="${nowUser.userimg}" title="点击编辑头像" onclick="update_userimg()">

        <div class="card-centent">
            <div class="user_name">
                <h2>${nowUser.username}</h2>
            </div>
            <!--					<div class="user_site">-->
            <!--						<span style="color: #00AEEC">所在位置</span>：湖南省郴州市-->
            <!--					</div>-->
        </div>

    </div>


    <div class="card-stats">
        <div class="category">
            <div class="number">
                账号：
            </div>
            <div class="type">
                ${nowUser.user}
            </div>
        </div>

        <div class="category">
            <div class="number">
                账号注册时间：
            </div>
            <div class="type">
                ${nowUser.creationtime}
            </div>
        </div>

        <div class="category">
            <div class="number">
                用户名：
            </div>
            <div class="type">
                ${nowUser.username}
            </div>
            <div class="redact">
                <button type="button" class="layui-btn layui-btn-primary layui-btn-radius" onclick="update_username1()">
                    编辑
                </button>
            </div>
        </div>


        <div class="category">
            <div class="number">
                收货地址:
            </div>
            <div class="type">
                ${UserAddress.address}
            </div>
            <div class="redact">
                <button type="button" class="layui-btn layui-btn-primary layui-btn-radius"
                        onclick="update_userredact1()">编辑
                </button>
            </div>

        </div>

        <div class="category">
            <div class="number">
                个性签名：
            </div>
            <div class="type">
                ${UserSignature.signature}
            </div>
            <div class="redact">
                <button type="button" class="layui-btn layui-btn-primary layui-btn-radius" onclick="update_usersign1()">
                    编辑
                </button>
            </div>
        </div>


    </div>
</div>

<!--弹出层显示-->
<!--修改用户名-->
<div hidden id="username">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>用户名修改</legend>
    </fieldset>
    <form class="layui-form" action="" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" id="username_userid" lay-verify="required" lay-reqtext="不能为空" placeholder="请输入"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn" lay-submit="" lay-filter="demo1" onclick="update_username2('${nowUser.id}')">立即提交</button>
            </div>
        </div>
    </form>
</div>

<!--修改用户收货地址-->
<div hidden id="userredact">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>用户收货地址修改</legend>
    </fieldset>
    <form class="layui-form" action="" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">新地址</label>
            <div class="layui-input-block">
                <input type="text" id="userredact_userid" lay-verify="required" lay-reqtext="不能为空" placeholder="请输入"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn" lay-submit="" lay-filter="demo1" onclick="update_userredact2('${nowUser.id}')">立即提交</button>
            </div>
        </div>
    </form>
</div>

<!--修改个性签名-->
<div hidden id="usersign">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>个性签名修改</legend>
    </fieldset>
    <form class="layui-form" action="" method="post">
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">新签名</label>
            <div class="layui-input-block">
                <textarea id="booksynopsis" name="booksynopsis" placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn" lay-submit="" lay-filter="demo1" onclick="update_usersign2('${nowUser.id}')">立即提交</button>
            </div>
        </div>
    </form>
</div>

<!--修改头像-->
<div hidden id="userimg">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>头像修改</legend>
    </fieldset>
    <div class="layui-upload">
        <button type="button" class="layui-btn" id="test1">上传图片</button>
        <div class="layui-upload-list">
            <img class="layui-upload-img" id="demo1" width="200px">
            <p id="demoText"></p>
        </div>
        <div style="width: 95px;">
            <div class="layui-progress layui-progress-big" lay-showpercent="yes" lay-filter="demo">
                <div class="layui-progress-bar" lay-percent=""></div>
            </div>
        </div>
    </div>

    <a name="list-progress"> </a>

    <div style="margin-top: 10px;"></div>
</div>


<script>
    /*用户名修改*/
    function update_username1() {
        layer.open({
            type: 1,
            content: $('#username'),
            area: ['740px', 'auto'], //宽高
            resize: false
        });

    }
    function update_username2(userid) {
        var username_userid = $("#username_userid").val();
        // alert(username_userid)
        $.ajax({
            url: "../user/updateusername_userid",
            type: "post",
            data: {
                userid:userid,
                username_userid:username_userid
            },
            success: function (data) {
                if(data=="1"){
                    location.reload()
                }else{
                    layer.msg("修改失败")
                }
            },
            error: function (data) {
                alert("失败")
            }
        });
    }

    /*用户收货地址修改*/
    function update_userredact1() {
        layer.open({
            type: 1,
            content: $('#userredact'),
            area: ['740px', 'auto'], //宽高
            resize: false
        });
    }
    function update_userredact2(userid) {
        var userredact_userid = $("#userredact_userid").val();
        $.ajax({
            url: "../user/update_userredact_userid",
            type: "post",
            data: {
                userid:userid,
                userredact_userid:userredact_userid
            },
            success: function (data) {
                if(data=="1"){
                    location.reload()
                }else{
                    layer.msg("修改失败")
                }
            },
            error: function (data) {
                alert("失败")
            }
        })
    }




    /*个性签名修改*/
    function update_usersign1() {
        layer.open({
            type: 1,
            content: $('#usersign'),
            area: ['740px', 'auto'], //宽高
            resize: false
        });
    }
    function update_usersign2(userid) {
        var booksynopsis = $("#booksynopsis").val();
        $.ajax({
            url: "../user/update_usersign_userid",
            type: "post",
            data: {
                userid:userid,
                booksynopsis:booksynopsis
            },
            success: function (data) {
                if(data=="1"){
                    location.reload()
                }else{
                    layer.msg("修改失败")
                }
            },
            error: function (data) {
                alert("失败")
            }
        })
    }




    /*用户头像修改*/
    function update_userimg() {
        layer.open({
            type: 1,
            content: $('#userimg'),
            area: ['540px', '540px'], //宽高
            resize: false
        });

        layui.use(['upload', 'element', 'layer'], function () {
            var $ = layui.jquery
                , upload = layui.upload
                , element = layui.element
                , layer = layui.layer;

            //常规使用 - 普通图片上传
            var uploadInst = upload.render({
                elem: '#test1'
                , url: '../user/updateuserimg' //此处用的是第三方的 http 请求演示，实际使用时改成您自己的上传接口即可。
                , before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#demo1').attr('src', result); //图片链接（base64）
                    });

                    element.progress('demo', '0%'); //进度条复位
                    layer.msg('上传中', {icon: 16, time: 0});
                }
                , done: function (res) {
                    //如果上传失败
                    if (res.code > 0) {
                        return layer.msg('上传失败');
                    }
                    //上传成功的一些操作
                    console.log("成功")
                    $('#demoText').html(''); //置空上传失败的状态
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText');
                    demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                    demoText.find('.demo-reload').on('click', function () {
                        uploadInst.upload();
                    });
                }
                //进度条
                , progress: function (n, elem, e) {
                    element.progress('demo', n + '%'); //可配合 layui 进度条元素使用
                    if (n == 100) {
                        layer.msg('上传完毕', {icon: 1});
                    }
                }
            });

        });


    }


</script>
</body>
</html>
