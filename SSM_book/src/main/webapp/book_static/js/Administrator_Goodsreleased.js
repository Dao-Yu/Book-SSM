//图片上传
function uploadimg() {
    //获取上传数据
    var file = $("#photo")[0].files[0];
    var file2 = $("#photo2")[0].files[0];
    //使用forData对象存储上传数据
    var formData = new FormData();
    formData.append("photo", file);//上传的数据可以声明多组，一组为一个键值对数据
    formData.append("photo2", file2);

    //发起ajax请求
    $.ajax({
        type: "post",
        url: "../admin/uploadimg",
        processData: false,
        contentType: false,
        data: formData,//请求数据，要上传的资源
        success: function (data) {//回调函数
            // eval("var obj="+data);
            if (data.state) {
                alert("上传成功")
                $("#uploadspan").html("<img src='" + data.url + "' width='100px'>");
                $("#imgUrl").val(data.url);

                $("#uploadspan2").html("<img src='" + data.url2 + "' width='100px'>")
                $("#imgUrl2").val(data.url2);

            } else {
                alert("上传失败")
            }
        }

    });


}

