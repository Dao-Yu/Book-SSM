function update_user(bookid) {
    // alert(bookid);
    $.ajax({
        url: "../admin/updatecommodity_bookid",
        type: "post",
        data: {
            bookid: bookid
        },
        success: function (data) {
            // alert("wdnmd")
        },
        error: function (data) {
            alert("失败")
        }
    });
    layer.open({
        type: 2,
        title: "商品信息修改",
        area: ['740px', '650px'], //宽高
        content: 'Administrator_commodity_update.jsp',
        shade: 0,
        skin: '.layui_divcss',
        // content:'确认修改'
    });

};

function delete_user(bookid) {
    layer.open({
        content: '确认删除吗？',
        yes: function (index) {
            $.ajax({
                url: "../admin/deletecommodity",
                type: "post",
                data: {
                    bookid: bookid
                },
                success: function (data) {
                    // alert("wdnmd")
                    // window.opener.location.href= window.opener.location.href;
                    layer.close(index);
                    location.reload();
                },
                error: function (data) {
                    alert("失败")
                }
            });
        }
    });
}