package com.feng.service;

import com.feng.entity.BookInfoEntity;
import com.feng.entity.BookcommentEntity;
import com.feng.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShowService {
    //查询热门商品
    List<BookInfoEntity> Selecttopbooks();

    //查询所有商品
    List<BookInfoEntity> Selectbooks();

    //查询一本书的所有信息
    BookInfoEntity SelectOnebook(int id);

    //按照书名搜索
    List<BookInfoEntity> selectbookOnbookname(String bookname);

    //用户发表评论
    int inboookcomment(int userid, int bookid, String comment, String commenttime);

    //书本评论展示
    List<UserEntity> selectbookcomment_user(int bookid);

    //用户动态展示
    List<UserEntity> selectDynamicissue();
}
