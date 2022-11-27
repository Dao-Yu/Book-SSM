/*用户头像下拉栏*/
function menuToggle() {
    const toggleMenu = document.querySelector(".user_menu");
    toggleMenu.classList.toggle('active')
}


/*没有用户登录的状态时用户头像隐藏*/
$(window).ready(function () {
    $("#user_li").show();
    var user = $(".user_menu h3").text()
    if (user != "") {
        // console.log("不为空")
        console.log(user)
        $("#user_li").show();
        $("#user_li_login").hide();
    } else {
        console.log("为空")
        console.log(user)
        $("#user_li").hide();
        $("#user_li_login").show();
    }

});

