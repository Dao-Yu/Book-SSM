<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品管理</title>
    <%--    <meta http-equiv="refresh" content="5">--%>
    <% String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;
    %>
    <base href="<%=basePath%>">
    <%--在所请求跳转页面加上防止页面丢失 --%>


    <link rel="stylesheet" type="text/css" href="css/Administrator_commodity.css">
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">

    <script src="js/Administrator_commodity.js"></script>
    <script src="js/jquery-3.6.0.min.js"></script>
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
            ,url:'${pageContext.request.contextPath}/admin/commodity' // 此处为静态模拟数据，实际使用时需换成真实接口
            ,height: 'full-20' // 最大高度减去其他容器已占有的高度差
            ,cellMinWidth: 80
            ,totalRow: false // 开启合计行
            ,page: false
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'id', fixed: 'left', width:80, title: 'ID', sort: true, totalRowText: '合计：'}
                ,{field:'bookname', width:280, title: '商品名称'}
                ,{field:'bookauthor', width:107, title: '作者'}
                // ,{field:'imgurl', width:180, title: '商品图片'}
                // ,{field:'imgurl2', width:180, title: '商品海报'}
                ,{field:'bookprice', width:80, title: '价格'}
                ,{field:'booktype', width:80, title: '类别'}
                ,{field:'bookamount', width:80, title: '库存'}
                ,{field:'booksynopsis', width:380, title: '商品介绍'}
                ,{field:'booktime', title:'上架时间', width: 200}
                ,{field:'bookCollection', title:'被收藏数', width: 80}
                ,{field:'bookstate', title:'状态', width: 80}
                ,{fixed: 'right', title:'操作', width: 180, minWidth: 125, toolbar: '#barDemo'}
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
                    var bookid = data.id;
                    $.ajax({
                        url: "${pageContext.request.contextPath}/admin/deletecommodity",
                        type: "post",
                        data: {
                            bookid:bookid
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
                    area: ['80%','80%'],
                    shadeClose:true,//点别的地方则关闭当前layer
                    fixed:false,
                    content: './Administrator_commodity_update.jsp',
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

    });
</script>




</body>
</html>