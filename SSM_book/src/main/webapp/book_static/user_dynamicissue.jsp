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

    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <link  rel="stylesheet" type="text/css" href="css/user_dynamicissue.css">

    <script src="js/jquery-3.6.0.min.js"></script>
</head>
<body>
    <header>
        发布动态
    </header>

    <div class="layui-container">
        <div class="layui-row">
            <form class="layui-form" action=" ${pageContext.request.contextPath}/user/addDynamic" method="post">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">发布内容</label>
                    <div class="layui-input-block">
                        <textarea  name="usertype" placeholder="请输入内容(1000字以内)" class="layui-textarea"></textarea>
                    </div>
                </div>

                <%--一个隐藏域--%>
                <input type="hidden" id="goodimage" name="goodimage" value="">

                <div class="layui-form-item">
                    <label class="layui-form-label">图片上传</label>
                    <div class="layui-input-block">
                        <button type="button" class="layui-btn" id="upload">
                            <i class="layui-icon">&#xe67c;</i>上传图片(图片名字不要含中文)
                        </button>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">图片预览</label>
                    <div class="layui-input-block">
                        <img id="image" alt="" style="width: 75%;min-height: 300px;height: auto">
                    </div>
                </div>


                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>



    <script src="layui/layui.js"></script>

    <script>

        //图片上传
        layui.use('upload', function(){
            var upload = layui.upload;
            var $ = layui.$;
            //执行实例
            var uploadInst = upload.render({
                elem: '#upload' //绑定元素
                ,url: '../user/upload' //上传接口
                ,done: function(res){
                    //上传完毕回调
                    if(res.code==1){
                        layer.msg(res.msg)
                        //首先要获得图片上传之后的图片访问路径
                        var imagePath = res.data.src;
                        $("#image").attr("src",imagePath);
                        $("#goodimage").attr("value",imagePath);
                    }else{
                        layer.msg(res.msg)
                    }
                }
                ,error: function(){
                    //请求异常回调
                }
            });
        });
    </script>

</body>
</html>