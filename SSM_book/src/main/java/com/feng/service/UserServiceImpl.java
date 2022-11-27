package com.feng.service;

import com.feng.dao.UserEntityMapper;
import com.feng.entity.*;
import com.feng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserEntityMapper userEntityMapper;

    //用户登录
    @Override
    public UserEntity login(String user) {
        UserEntity userEntityList = userEntityMapper.login(user);
//        System.out.println(user);
        return userEntityList;
    }

    //用户注册
    @Override
    public int rigsht(String username, String user, String password, String email, String creationtime) {
        int userlist = userEntityMapper.rigsht(username, user, password, email, creationtime);
        return userlist;
    }

    //用户收藏
    @Override
    public int insertUserCollect(int userid, int bookid) {
        int collect = userEntityMapper.insertUserCollect(userid, bookid);
        return collect;
    }

    //收藏加1
    @Override
    public int updateUserCollectadd(int bookid) {
        int i = userEntityMapper.updateUserCollectadd(bookid);
        return 0;
    }

    //查看用户是否已收藏，防止重复收藏
    @Override
    public UsercollectEntity usercollect(int userid, int bookid) {
        UsercollectEntity usercollectEntity = userEntityMapper.usercollect(userid, bookid);
        return usercollectEntity;
    }

    //用户收藏显示
    @Override
    public List<BookInfoEntity> userbookcollect(String user) {
        List<BookInfoEntity> bookInfoEntity = userEntityMapper.userbookcollect(user);
        return bookInfoEntity;
    }

    //用户取消收藏
    @Override
    public int deleteuserbookcollect(int bookid) {
        int deleteusercollect = userEntityMapper.deleteuserbookcollect(bookid);
        return deleteusercollect;
    }

    //收藏减1
    @Override
    public int updateUserCollectdelete(int bookid) {
        int i = userEntityMapper.updateUserCollectdelete(bookid);
        return i;
    }

    //用户加入购物车
    @Override
    public int insertbookshopping(int userid, int bookid) {
        int i = userEntityMapper.insertbookshopping(userid, bookid);
        return i;
    }

    //查询用户是否已经加入购物车，已加入则提醒
    @Override
    public BookshoopingEntity bookshopping(int userid, int bookid) {
        return userEntityMapper.bookshopping(userid, bookid);
    }

    //用户购物车商品显示
    @Override
    public List<BookInfoEntity> userbookshopping(String user) {
        return userEntityMapper.userbookshopping(user);
    }

    //用户点击购物车中的删除，取消加入购物车
    @Override
    public int deletebookshopping(int bookid) {
        return userEntityMapper.deletebookshopping(bookid);
    }

    //查询单个用户
    @Override
    public UserEntity selectOnUser(int userid) {
        return userEntityMapper.selectOnUser(userid);
    }

    //用户修改用户名
    @Override
    public int updateusername(int userid, String newusername) {
        return userEntityMapper.updateusername(userid,newusername);
    }

    //查询用户收货地址信息
    @Override
    public UseraddressEntity useraddressEntity(int userid) {
        return userEntityMapper.useraddressEntity(userid);
    }

    //修改用户收货地址信息
    @Override
    public int updateaddress(String address, int userid) {
        return userEntityMapper.updateaddress(address,userid);
    }

    //查询用户个性签名
    @Override
    public UsersignatureEntity usersignatureEntity(int userid) {
        return userEntityMapper.usersignatureEntity(userid);
    }

    //修改个性签名
    @Override
    public int updatesignature(String signature, int userid) {
        return userEntityMapper.updatesignature(signature,userid);
    }

    //用户发布动态
    @Override
    public int addDynamic(int userid, String dynamictime, String usertype, String goodimage) {
        return userEntityMapper.addDynamic(userid,dynamictime,usertype,goodimage);
    }

}
