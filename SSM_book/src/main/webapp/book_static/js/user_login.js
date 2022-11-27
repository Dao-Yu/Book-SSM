/*隐藏内容*/
$(window).ready(function () {
    $(".login_box span").hide();
});

/*账号正则判定方法*/
var tologin_user = function () {
    var user = $("#user").val();
    var user_number = /^(0|[1-9][0-9]{5,11})$/;
    var objuser = new RegExp(user_number);
    if (objuser.test(user) == true) {
        return true;
    } else {
        return false;
    }
}

/*密码正则判定方法*/
var tologin_password = function () {
    var password = $("#password").val();
    var password_illegal = /^[a-zA-Z]\w{5,17}$/;
    var objpassword = new RegExp(password_illegal);
    /*密码正则*/
    if (objpassword.test(password) == true) {
        return true;
    } else {
        return false;
    }
}

/*用户登录开始*/


function tologin() {
// alert(11111)
    alert(tologin_user())
    if (tologin_user() == true && tologin_password() == true) {
        alert(tologin_user())
        $(".login_box span").hide();

        var user = $("#user").val();
        var password = $("#password").val();


        $.ajax({
            url: "../user/login",
            type: "post",
            // dataType:"json",
            data: JSON.stringify({
                user: user,
                password: password
            }),
            contentType: "application/json;charset=utf8",
            success: function (d) {
                console.log(d)
            },
            error: function (data) {
                alert("错误")
            }
        });

    } else {
        if (tologin_user() == false) {
            $(".login_box span").show();

        }
        if (tologin_password() == false) {
            $(".span2").show();

        }
    }

}

/*用户登录结束*/