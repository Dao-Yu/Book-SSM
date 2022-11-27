package com.feng.service;

import com.feng.dao.ShowMapper;
import com.feng.entity.BookInfoEntity;
import com.feng.entity.BookcommentEntity;
import com.feng.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    ShowMapper showMapper;

    //查询热门商品
    @Override
    public List<BookInfoEntity> Selecttopbooks() {
        List<BookInfoEntity> bookInfoEntityList = showMapper.Selecttopbooks();
        return bookInfoEntityList;
    }

    //查询所有商品
    @Override
    public List<BookInfoEntity> Selectbooks() {
        List<BookInfoEntity> bookInfoEntityList = showMapper.Selectbooks();
        return bookInfoEntityList;
    }

    //查询一本书的所有信息
    @Override
    public BookInfoEntity SelectOnebook(int id) {
        BookInfoEntity bookInfoEntity = showMapper.SelectOnebook(id);
        return bookInfoEntity;
    }

    //按照书名搜索
    @Override
    public List<BookInfoEntity> selectbookOnbookname(String bookname) {
        List<BookInfoEntity> bookInfoEntityList = showMapper.selectbookOnbookname(bookname);
        return bookInfoEntityList;
    }

    //用户发表评论
    @Override
    public int inboookcomment(int userid, int bookid, String comment, String commenttime) {
        int i = showMapper.inboookcomment(userid, bookid, comment, commenttime);
        return i;
    }


    //书本评论展示
    @Override
    public List<UserEntity> selectbookcomment_user(int bookid) {
        List<UserEntity> userEntityList = showMapper.selectbookcomment_user(bookid);
        return userEntityList;
    }

    //用户动态展示
    @Override
    public List<UserEntity> selectDynamicissue() {
        return showMapper.selectDynamicissue();
    }

}
