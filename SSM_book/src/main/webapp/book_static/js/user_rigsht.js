$(window).ready(function () {
    $(".rigsht_box span").hide();
    // $("#username").torigsht_username();
    // $("#user").torigsht_user();
    // $("#password").torigsht_password();
    // // $("#password2").torigsht_password2();
    // $("#email").torigsht_email();
});

/*用户名正则判定*/
$.fn.torigsht_username = function () {
    var username = $("#username").val();
    var username_regular = /[\w\u4e00-\u9fa5]{2,12}/;
    var username_regexp = new RegExp(username_regular);

    if (username_regexp.test(username) == true) {
        alert(username)
        $(".span1").hide();
    } else {
        // alert("用户名必须为2-12位字母/数字/中文")
        $(".span1").show();
    }
};

/*账号正则判断*/
$.fn.torigsht_user = function () {
    /*账号*/
    var user = $("#user").val();
    var user_regular = /^(0|[1-9][0-9]{5,11})$/;
    var user_regexp = new RegExp(user_regular);
    if (user_regexp.test(user) == true) {
        alert(user)
        $(".span2").hide();
    } else {
        // alert("账号不能含非数字和首字符为0且账号长度为6至11位");
        $(".span2").show();
    }
};

/*密码正则判定*/
$.fn.torigsht_password = function () {
    /*密码*/
    var password = $("#password").val();
    var password2 = $("#password2").val();
    var password_regular = /^[a-zA-Z]\w{5,17}$/;
    var password_regexp = new RegExp(password_regular);

    if (password_regexp.test(password) == true) {
        alert(password)
        $(".span3").hide();
        /*确认密码判断*/
        if (password.trim() == password2.trim()) {
            alert(password2)
            $(".span4").hide();
        } else {
            // alert("两次密码输入不一致")
            $(".span4").show();
        }
    } else {
        // alert("密码不能为空，长度为6至16位且密码含有非法字符或没有以字母开头")
        $(".span3").show();
    }
};


/*邮箱正则判定*/
$.fn.torigsht_email = function () {
    /*邮箱*/
    var email = $("#email").val();
    var email_regular = /^[a-zA-Z0-9][\w\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\w\.-]*[a-zA-Z0-9]\.[a-zA-Z][a-zA-Z\.]*[a-zA-Z]$/;
    var email_regexp = new RegExp(email_regular);
    if (email_regexp.test(email) == true) {
        alert(email)
        $(".span5").hide();
    } else {
        // alert("邮箱格式错误，请输入正确邮箱")
        $(".span5").show();
    }
};


/*用户注册开始*/
function torigsht() {
    $("#username").torigsht_username();
    $("#user").torigsht_user();
    $("#password").torigsht_password();
    // $("#password2").torigsht_password2();
    $("#email").torigsht_email();
}

/*用户注册结束*/
