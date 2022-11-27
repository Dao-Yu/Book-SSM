package com.feng.controller;

import com.feng.entity.*;
import com.feng.service.Admin_userService;
import com.feng.service.ShowService;
import com.feng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ShowController {
    //页面展示内容
    @Autowired
    ShowService showService;

    @Autowired
    Admin_userService admin_userService;

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String run(HttpSession session) {
        //所有商品
        List<BookInfoEntity> bookInfoEntityList = showService.Selectbooks();
        session.setAttribute("nowBooks", bookInfoEntityList);
        //热门商品
        List<BookInfoEntity> bookInfoEntityList1 = showService.Selecttopbooks();
//        System.out.println("热门商品："+bookInfoEntityList1);
        session.setAttribute("nowTopBooks", bookInfoEntityList1);
        return "index";
    }

    //书圈动态查询
    @RequestMapping(value = "user/showbookcircle")
    @ResponseBody
    public String BookcircleSelect(HttpSession session){
        //查询所有动态
        List<UserEntity> userEntityList = showService.selectDynamicissue();
        session.setAttribute("UserDynamicissue",userEntityList);
        return "yes";
    }


    //页面热门商品展示和所有商品展示
//    @RequestMapping(value = "index/bookshow")
//    public String BookShow(HttpSession session){
//        //所有商品
//        List<BookInfoEntity> bookInfoEntityList = showService.Selectbooks();
//        session.setAttribute("nowBooks",bookInfoEntityList);
//        //热门商品
//        List<BookInfoEntity> bookInfoEntityList1 = showService.Selecttopbooks();
////        System.out.println("热门商品："+bookInfoEntityList1);
//        session.setAttribute("nowTopBooks",bookInfoEntityList1);
//        return "index";
//    }

    //书本详情页
    @RequestMapping(value = "index/bookparticulars.do")
    public String Bookparticulars(@RequestParam int id, HttpSession session) {
        BookInfoEntity bookInfoEntity = showService.SelectOnebook(id);
        //一本书的全部信息
        session.setAttribute("thisbook", bookInfoEntity);

        //书本评论的用户
        int bookid = bookInfoEntity.getId();
        List<UserEntity> userEntityList = showService.selectbookcomment_user(bookid);
        session.setAttribute("thisbookcommentuser", userEntityList);
        return "bookparticulars";
    }

    //用户发表评论
    @RequestMapping(value = "index/boookcomment")
    public @ResponseBody
    String BookComment(@RequestParam("comment") String comment, HttpSession session) {
        //获取当前时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String commenttime = sdf.format(date);
        //获取书本id
        BookInfoEntity bookInfoEntity = (BookInfoEntity) session.getAttribute("thisbook");
        int bookid = bookInfoEntity.getId();
        //获取用户id
        UserEntity userEntity = (UserEntity) session.getAttribute("nowUser");
        if (userEntity != null) {
            int userid = userEntity.getId();
            showService.inboookcomment(userid, bookid, comment, commenttime);
            //刷新新数据
            List<UserEntity> userEntityList = showService.selectbookcomment_user(bookid);
            session.setAttribute("thisbookcommentuser", userEntityList);
            return "true";
        } else {
            return "false";
        }


    }

    //书库页页面详情
    @RequestMapping(value = "index/bookstackrooms")
    public String Bookstackrooms(HttpSession session) {
        //书库中的分类查询
        List<BookTypeEntity> bookTypeEntityList = admin_userService.selecttype();
        session.setAttribute("index_booktype", bookTypeEntityList);
        return "stackroom";
    }

    //点击收藏
    @RequestMapping(value = "index/bookcollect")
    public @ResponseBody
    String BookCollect(HttpSession session) {
//        System.out.println("进入");
        //获取用户id,并查看是否有用户登录
        UserEntity userEntity = (UserEntity) session.getAttribute("nowUser");
//        System.out.println(userEntity);
        //获取一个书本id
        BookInfoEntity bookInfoEntity = (BookInfoEntity) session.getAttribute("thisbook");
//        System.out.println(bookInfoEntity);

        if (userEntity == null) {
            return "false";
        } else {
            int userid = userEntity.getId();
            int bookid = bookInfoEntity.getId();
            //查看用户是否已收藏
            UsercollectEntity usercollectEntity = userService.usercollect(userid, bookid);

            if (usercollectEntity != null) {
                //用户已收藏
                return "user_true";
            } else {
                userService.insertUserCollect(userid, bookid);
                //收藏加1
                userService.updateUserCollectadd(bookid);
                return "true";
            }


        }

    }

    //点击加入购物车
    @RequestMapping(value = "index/bookshopping")
    public @ResponseBody
    String Bookshopping(HttpSession session) {
        //获取用户id,并查看是否有用户登录
        UserEntity userEntity = (UserEntity) session.getAttribute("nowUser");
        //获取一个书本id
        BookInfoEntity bookInfoEntity = (BookInfoEntity) session.getAttribute("thisbook");

        int userid = userEntity.getId();
        int bookid = bookInfoEntity.getId();
        //查看用户是否已加入购物车
        BookshoopingEntity bookshoopingEntity = userService.bookshopping(userid, bookid);

        if (bookshoopingEntity != null) {
            //用户已加入购物车
            return "book_true";
        } else {
            //否，则加入购物车
            userService.insertbookshopping(userid, bookid);
            return "true";
        }


    }


    //首页搜索
    @RequestMapping(value = "index/usersearch")
    public String index_search(@RequestParam("search") String search, HttpSession session) {
        List<BookInfoEntity> bookInfoEntityList = showService.selectbookOnbookname("%" + search + "%");
        session.setAttribute("selectbookOnbooknames", bookInfoEntityList);
        return "booksearch";
    }


}
