package com.feng.service;

import com.feng.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //用户登录,查询用户是否存在
    UserEntity login(String user);
    
    //用户注册
    int rigsht(String username, String user, String password, String email, String creationtime);

    //用户加入收藏类
    int insertUserCollect(int userid, int bookid);

    //点击收藏，收藏数加1
    int updateUserCollectadd(int bookid);

    //查看用户是否已收藏，防止重复收藏
    UsercollectEntity usercollect(int userid, int bookid);

    //用户收藏显示
    List<BookInfoEntity> userbookcollect(String user);

    //用户取消收藏
    int deleteuserbookcollect(int bookid);

    //点击收藏，收藏数减1
    int updateUserCollectdelete(int bookid);


    //用户加入购物车
    int insertbookshopping(int userid, int bookid);

    //查询用户是否已经加入购物车，已加入则提醒
    BookshoopingEntity bookshopping(int userid, int bookid);

    //用户购物车商品显示
    List<BookInfoEntity> userbookshopping(String user);

    //用户点击购物车中的删除，取消加入购物车
    int deletebookshopping(int bookid);

    //查询当个用户
    UserEntity selectOnUser(@Param("userid")int userid);
    //用户修改用户名
    int updateusername(int userid ,String newusername);

    //查询用户收货地址信息
    UseraddressEntity useraddressEntity(int userid);

    //修改用户收货地址信息
    int updateaddress(String address,int userid);

    //查询用户个性签名
    UsersignatureEntity usersignatureEntity(int userid);

    //修改个性签名
    int updatesignature(String signature,int userid);

    //用户发布动态
    int addDynamic(int userid,String dynamictime,String usertype,String goodimage);
}
