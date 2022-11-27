$(window).ready(function () {
    //用户管理
    $(".Administrator_usermanagement").click(function () {
        // alert(1)
        parent.$("#myiframe").attr("src", "Administrator_usermanagement.jsp");
    });
    //发布商品
    $(".Administrator_Goodsreleased").click(function () {
//		alert(1)
        parent.$("#myiframe").attr("src", "Administrator_Goodsreleased.jsp");
    });
    //商品管理
    $(".Administrator_commodity").click(function () {
//		alert(1)
        parent.$("#myiframe").attr("src", "Administrator_commodity.jsp");
    });
    //添加分类
    $(".Administrator_Addtype").click(function () {
        // alert(1)
        parent.$("#myiframe").attr("src", "Administrator_Addtype.jsp");
    });

});

//用户信息管理
function admin_user() {
    $.ajax({
        url: "../admin/user",
        type: "post",
        success: function (data) {
            // alert(data)
        },
        error: function (data) {
            alert("错误")
        }
    });
}

//商品信息管理
function admin_commodity() {
    $.ajax({
        url: "../admin/commodity",
        type: "post",
        success: function (data) {

        },
        error: function (data) {
            alert("错误")
        }
    });
}

//商品发布页的类别信息
function admin_type() {
    // alert(1)
    $.ajax({
        url: "../admin/Goodsreleased_type",
        type: "post"
    });
}

//添加类别
function admin_addtype() {
    // alert(111)
    $.ajax({
        url: "../admin/addbooktype",
        type: "post"
    })
}