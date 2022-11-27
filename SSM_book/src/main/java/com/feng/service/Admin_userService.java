package com.feng.service;

import com.feng.common.LayuiPageVo;
import com.feng.entity.BookInfoEntity;
import com.feng.entity.BookTypeEntity;
import com.feng.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Admin_userService {
    //用户信息管理（查询所有用户）
    List<UserEntity> userlist();

    //用户信息管理分页查询
//    LayuiPageVo<UserEntity> admin_user(Integer page, Integer limit);

    //删除用户信息
    int deleteuser(int userid);

    //修改用户信息
    int updateuser(int userjurisdiction, int userid);


    //商品信息管理
    List<BookInfoEntity> commoditylist();

    //商品类别
    List<BookTypeEntity> selecttype();

    //商品修改
    int updatcommodity(String bookname, String bookauthor, int bookstate, int bookCollection, int id);

    //获取一个商品的全部信息
    BookInfoEntity selectOneBook(int id);

    //删除商品信息
    int deletecommodity(int bookid);

    //查询所有类别
    List<BookTypeEntity> SelectbookType();

    //新增类别
    int inbooktype(String type);

    //删除类别
    int deletebooktype(int id);


}
