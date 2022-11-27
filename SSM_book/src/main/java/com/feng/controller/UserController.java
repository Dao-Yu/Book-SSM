package com.feng.controller;

import com.feng.entity.BookInfoEntity;
import com.feng.entity.UserEntity;
import com.feng.entity.UseraddressEntity;
import com.feng.entity.UsersignatureEntity;
import com.feng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller

public class UserController {
    @Autowired
    UserService userService;

    //用户登录开始
    @RequestMapping(value = "user/login")
    public String login(@RequestParam("user") String user,
                        @RequestParam("password") String password,
                        HttpSession session) {
        String userRegular = "^(0|[1-9][0-9]{5,11})$";
        String passwordRegular = "^[a-zA-Z]\\w{5,17}$";

        UserEntity userEntity = userService.login(user);
//        System.out.println("密码为："+password);
        System.out.println(userEntity);

        if (user.matches(userRegular) && password.matches(passwordRegular)) {
//            return "index";
            if (userEntity != null) {
                //判断账号是否存在（已验证）
//                return "index";
                if (password.equals(userEntity.getPassword())) {
                    //判断密码是否正确(已验证)
//                    return "index";
                    if (userEntity.getUserjurisdiction() == 0) {
                        //判断账号权限(已验证)
                        //后台管理页面
                        session.setAttribute("admin_nowUser", userEntity);
                        return "Administrator_user";
                    } else {
                        //首页
                        session.setAttribute("nowUser", userEntity);

                        //查询用户个性签名
                        /*UserEntity userEntity = (UserEntity) session.getAttribute("nowUser");
                        int userid = userEntity.getId();*/
                        UsersignatureEntity usersignatureEntity = userService.usersignatureEntity(userEntity.getId());
                        session.setAttribute("UserSignature",usersignatureEntity);
                        return "index";
                    }
                } else {
                    //密码错误
                    session.setAttribute("passwordFlag", false);
                    session.setAttribute("userFlag", true);
                    return "login";
                }
            } else {
                //账号不存在
                session.setAttribute("userFlag", false);
                session.setAttribute("passwordFlag", true);
                return "login";
            }
        } else {
            session.setAttribute("userFlag", false);
            return "login";
        }


    }
    //用户登录结束


    //用户注册开始
    @RequestMapping(value = "user/righst")
    public String rigsht(@RequestParam("username") String username,
                         @RequestParam("user") String user,
                         @RequestParam("password") String password,
                         @RequestParam("password2") String password2,
                         @RequestParam("email") String email, HttpSession session) {
        System.out.println(username);
        String usernameRegular = "[\\w\\u4e00-\\u9fa5]{2,12}";
        String userRegular = "^(0|[1-9][0-9]{5,11})$";
        String passwordRegular = "^[a-zA-Z]\\w{5,17}$";
        String emailRegular = "^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";

        //账号是否存在
        UserEntity userEntity = userService.login(user);
        //获取当前时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String creationtime = sdf.format(date);

//        System.out.println(creationtime);


//        &&user.matches(userRegular)&&password.matches(passwordRegular)&&email.matches(emailRegular)
        if (username.matches(usernameRegular)) {//用户名判断

            if (user.matches(userRegular)) {//账号判断

                if (password.matches(passwordRegular)) {//密码判断

                    if (password2.equals(password)) {//第二次密码判断

                        if (email.matches(emailRegular)) {//邮箱判断

                            //进入注册账号是否存在判断
                            if (userEntity == null) {//账号不存在则可以注册账号
                                userService.rigsht(username, user, password, email, creationtime);
                                return "login";
                            } else {
                                session.setAttribute("userFlag2", false);
                                return "rigsht";
                            }

                        } else {
                            //邮箱错误
                            session.setAttribute("emailFlag", false);

                            session.setAttribute("usernameFlag", true);
                            session.setAttribute("userFlag", true);
                            session.setAttribute("passwordFlag", true);
                            session.setAttribute("password2Flag", true);
                            return "rigsht";
                        }
                    } else {//第二次密码输入错误
                        session.setAttribute("password2Flag", false);

                        session.setAttribute("emailFlag", true);
                        session.setAttribute("usernameFlag", true);
                        session.setAttribute("userFlag", true);
                        session.setAttribute("passwordFlag", true);
                        return "rigsht";
                    }
                } else {
                    //密码错误
                    session.setAttribute("passwordFlag", false);

                    session.setAttribute("password2Flag", true);
                    session.setAttribute("emailFlag", true);
                    session.setAttribute("usernameFlag", true);
                    session.setAttribute("userFlag", true);
                    return "rigsht";
                }
            } else {
                //账号格式错误
                session.setAttribute("userFlag", false);

                session.setAttribute("passwordFlag", true);
                session.setAttribute("password2Flag", true);
                session.setAttribute("emailFlag", true);
                session.setAttribute("usernameFlag", true);
                return "rigsht";
            }
        } else {
            //用户名格式错误
            session.setAttribute("usernameFlag", false);

            session.setAttribute("userFlag", true);
            session.setAttribute("passwordFlag", true);
            session.setAttribute("password2Flag", true);
            session.setAttribute("emailFlag", true);
            return "rigsht";
        }


    }
    //用户注册结束


    //用户收藏商品显示
    @RequestMapping(value = "user/userboookcollect")
    public String usercollect(HttpSession session) {
        UserEntity userEntity = (UserEntity) session.getAttribute("nowUser");
        String user = userEntity.getUser();

        List<BookInfoEntity> bookInfoEntity = userService.userbookcollect(user);
        session.setAttribute("Userbooks", bookInfoEntity);
        return "user_bookcollect";
    }

    //用户购物车商品显示
    @RequestMapping(value = "user/userbookshopping")
    public String usershopping(HttpSession session) {
        UserEntity userEntity = (UserEntity) session.getAttribute("nowUser");
        String user = userEntity.getUser();

        List<BookInfoEntity> bookInfoEntity = userService.userbookshopping(user);
        session.setAttribute("ShoppingBooks", bookInfoEntity);
        return "user_shopping";
    }

    //用户取消收藏
    @RequestMapping(value = "user/deleteuserboookcollect")
    public String deleteuserbookcollect(@RequestParam int bookid, HttpSession session) {
        //取消收藏
        userService.deleteuserbookcollect(bookid);
        userService.updateUserCollectdelete(bookid);
        //将新数据刷新到前端
        UserEntity userEntity = (UserEntity) session.getAttribute("nowUser");
        String user = userEntity.getUser();

        List<BookInfoEntity> bookInfoEntity = userService.userbookcollect(user);
        session.setAttribute("Userbooks", bookInfoEntity);

        return "user_bookcollect";
    }

    //用户取消加入购物车
    @RequestMapping(value = "/user/deletebookshopping")
    public String deletebookshopping(@RequestParam int bookid, HttpSession session) {
        //取消加入购物车
        userService.deletebookshopping(bookid);
        //再刷新一遍数据
        UserEntity userEntity = (UserEntity) session.getAttribute("nowUser");
        String user = userEntity.getUser();

        List<BookInfoEntity> bookInfoEntity = userService.userbookshopping(user);
        session.setAttribute("ShoppingBooks", bookInfoEntity);

        return "user_shopping";
    }


    //用户退出登录
    @RequestMapping(value = "user/out")
    public String UserOut(HttpSession session) {
        session.setAttribute("nowUser", "iverson");
        session.removeAttribute("nowUser");
        return "index";
    }

    //用户修改头像
//    @RequestMapping(value = "user/updateuserimg")
//    @ResponseBody
//    public String Userupdateuserimg(String path, HttpServletRequest request){
//        System.out.println("进入了头像上传功能");
//
//        return "{id: 123, abc: 'xxx'}";
//    }

    //点击资料，展示用户所有个人信息
    @RequestMapping(value = "user/userShow")
    public @ResponseBody String UserShow(HttpSession session){
        //获取登录用户的id
        UserEntity userEntity = (UserEntity) session.getAttribute("nowUser");
        int userid = userEntity.getId();
        //通过id可查询用户的所有信息，但这是查询用户的收货地址信息
        UseraddressEntity useraddressEntity = userService.useraddressEntity(userid);
        session.setAttribute("UserAddress",useraddressEntity);
        //查询用户个性签名
        UsersignatureEntity usersignatureEntity = userService.usersignatureEntity(userid);
        session.setAttribute("UserSignature",usersignatureEntity);
        return "yes";
    }


    //用户修改用户名
    @RequestMapping(value = "user/updateusername_userid")
    public @ResponseBody String Userupdateusername(@RequestParam int userid,@RequestParam("username_userid") String newusername,HttpSession session){
        int i = userService.updateusername(userid,newusername);

        if(i>0){
            UserEntity userEntity = userService.selectOnUser(userid);
            session.setAttribute("nowUser", userEntity);
            return "1";
        }else{
            return "0";
        }

    }

    //用户修改收货地址
    @RequestMapping(value = "user/update_userredact_userid")
    public @ResponseBody String Userupdateuserredact(@RequestParam int userid,@RequestParam("userredact_userid") String newuserredact,HttpSession session){
//        System.out.println("用户id为"+userid);
//        System.out.println("新收货地址为"+newuserredact);
        int i = userService.updateaddress(newuserredact,userid);
        if(i>0){
            UseraddressEntity useraddressEntity = userService.useraddressEntity(userid);
            session.setAttribute("UserAddress",useraddressEntity);
            return "1";
        }else{
            return "0";
        }

    }

    //用户修改个性签名
    @RequestMapping(value = "user/update_usersign_userid")
    public @ResponseBody String Userupdateusersign(@RequestParam int userid,@RequestParam("booksynopsis")String booksynopsis,HttpSession session ){
        int i = userService.updatesignature(booksynopsis,userid);

        if(i>0){
            UsersignatureEntity usersignatureEntity = userService.usersignatureEntity(userid);
            session.setAttribute("UserSignature",usersignatureEntity);
            return "1";
        }else{
            return "0";
        }
    }

    //用户发布动态
    @RequestMapping(value = "user/addDynamic")
    public String AddDynamic(@RequestParam("goodimage")String goodimage,@RequestParam("usertype")String usertype,HttpSession session){
//        System.out.println("图片地址"+goodimage);
//        System.out.println("内容"+usertype);
        //获取当前用户的id
        UserEntity userEntity = (UserEntity) session.getAttribute("nowUser");
        int userid = userEntity.getId();
        //获取当前时间
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dynamictime = dateFormat.format(date);


        userService.addDynamic(userid,dynamictime,usertype,goodimage);

        return "bookcircle";
    }


}
