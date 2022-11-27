package com.feng.dao;

import com.feng.entity.BookInfoEntity;
import com.feng.entity.BookcommentEntity;
import com.feng.entity.UserDynamicissueEutity;
import com.feng.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShowMapper {
    //查询热门商品
//    @Select("SELECT * FROM bookInfo ORDER BY bookCollection DESC LIMIT 5")
    @Select("SELECT * FROM bookInfo ORDER BY bookCollection")
    List<BookInfoEntity> Selecttopbooks();

    //查询所有商品
    @Select("select * from bookInfo")
    List<BookInfoEntity> Selectbooks();

    //书本详情页，查询一本书的所有信息
    @Select("select * from bookInfo where id=#{id}")
    BookInfoEntity SelectOnebook(@Param("id") int id);

    //按照书名搜索
    @Select("select * from bookInfo where bookname like #{bookname}")
    List<BookInfoEntity> selectbookOnbookname(String bookname);

    //用户发表评论
    @Insert("INSERT INTO bookcomment(userid,bookid,COMMENT,commenttime)VALUES(#{userid},#{bookid},#{comment},#{commenttime});")
    int inboookcomment(@Param("userid") int userid, @Param("bookid") int bookid, @Param("comment") String comment, @Param("commenttime") String commenttime);

    //展示用户评论
    //@Select("SELECT u.id,u.username,u.userimg,bcomment.comment,bcomment.commenttime FROM bookcomment bcomment LEFT JOIN USER u ON bcomment.userid=u.id")
    List<UserEntity> selectbookcomment_user(@Param("bookid") int bookid);

    //展示用户动态
    List<UserEntity> selectDynamicissue();




}
