<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;

    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>

    <link rel="stylesheet" type="text/css" href="css/Administrator_usermanag.css">
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script src="js/Administrator_usermanagement.js"></script>

    <script src="layui/layui.js"></script>
</head>
<body>

<table class="layui-hide" id="test" lay-filter="test"></table>


<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit" >编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>



<script>
    layui.use(['table', 'dropdown'], function(){
        var table = layui.table;
        var dropdown = layui.dropdown;

        // 创建渲染实例
        table.render({
            elem: '#test'
            ,url:'${pageContext.request.contextPath}/admin/user' // 此处为静态模拟数据，实际使用时需换成真实接口
            ,height: 'full-30' // 最大高度减去其他容器已占有的高度差
            ,cellMinWidth: 80
            ,totalRow: false // 开启合计行
            ,page: false
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'id', fixed: 'left', width:80, title: 'ID', sort: true, totalRowText: '合计：'}
                ,{field:'user', width:120, title: '账号'}
                ,{field:'username', width:280, title: '用户名'}
                ,{field:'email', title:'邮箱 <i class="layui-icon layui-icon-email"></i>', hide: 0, width:280, edit: 'text'}
                ,{field:'creationtime', title:'加入时间', width: 200}
                ,{field:'userjurisdiction', title:'权限', width: 80}
                ,{fixed: 'right', title:'操作', width: 280, minWidth: 125, toolbar: '#barDemo'}
            ]]
            ,error: function(res, msg){
                console.log(res, msg)
            }
        });

        // 触发单元格工具事件
        table.on('tool(test)', function(obj){ // 双击 toolDouble
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    var userid = data.id;
                    $.ajax({
                        url: "${pageContext.request.contextPath}/admin/deleteuser",
                        type: "post",
                        data: {
                            userid:userid
                        },
                        success: function (data) {

                            if(data.code==200){
                                obj.del();
                                layer.msg("删除成功");
                                table.reload("test");//重新加载
                            }else{
                                layer.msg("删除失败")
                            }
                        },
                        error: function (data) {
                            alert("错误")
                        }
                    });
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                //把要修改的数据存到localStorage,跳转到修改页面，再取出来展示要修改的数据
                localStorage.setItem("user",JSON.stringify(data));

                layer.open({
                    title: '编辑',
                    type: 2,
                    area: ['50%','30%'],
                    shadeClose:true,//点别的地方则关闭当前layer
                    fixed:false,
                    content: './Administrator_usermanagement_update.jsp',
                    end:function (index) {
                        table.reload("test")
                    }
                });
            }
        });

        //触发表格复选框选择
        table.on('checkbox(test)', function(obj){
            console.log(obj)
        });

        //触发表格单选框选择
        table.on('radio(test)', function(obj){
            console.log(obj)
        });


        // 行单击事件
        table.on('row(test)', function(obj){
            //console.log(obj);
            //layer.closeAll('tips');
        });
        // 行双击事件
        table.on('rowDouble(test)', function(obj){
            console.log(obj);
        });

        // 单元格编辑事件
        // table.on('edit(test)', function(obj){
        //     var field = obj.field //得到字段
        //         ,value = obj.value //得到修改后的值
        //         ,data = obj.data; //得到所在行所有键值
        //
        //     var update = {};
        //     update[field] = value;
        //     obj.update(update);
        // });
    });
</script>

</body>

</html>