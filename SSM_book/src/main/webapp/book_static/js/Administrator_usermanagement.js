function update_user(userid) {
    layer.open({
        type: 2,
        title: "用户信息修改",
        area: ['740px', '450px'], //宽高
        content: 'Administrator_usermanagement_update.jsp',
        shade: 0,
        skin: '.layui_divcss'
    });
    $.ajax({
        url: "../admin/updateuser_userid",
        type: "post",
        data: {
            userid: userid
        },
        success: function (data) {
            // alert(data)
        },
        error: function (data) {
            alert("错误")
        }
    });
};

function delete_user(userid) {
    layer.open({
        content: '确认删除吗？',
        yes: function (index) {
            $.ajax({
                url: "../admin/deleteuser",
                type: "post",
                data: {
                    userid: userid
                },
                success: function (data) {
                    layer.close(index);
                    location.reload();
                },
                error: function (data) {
                    alert("错误")
                }
            });
        }
    });
}