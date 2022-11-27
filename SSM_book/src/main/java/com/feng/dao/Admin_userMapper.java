package com.feng.dao;

import com.feng.common.LayuiPageVo;
import com.feng.entity.BookInfoEntity;
import com.feng.entity.BookTypeEntity;
import com.feng.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Admin_userMapper {
    //用户信息管理
    @Select("select id,username,user,password,email,creationtime,userjurisdiction from user;")
    List<UserEntity> userlist();

    //用户信息管理分页查询
    @Select("SELECT * FROM USER LIMIT #{page},#{limit};")
    List<UserEntity> userList(@Param("page")int page,@Param("limit") int limit );

    //删除用户
    @Delete("delete from USER where id = #{userid}")
    int deleteuser(@Param("userid") int userid);

    //修改用户
    @Update("update user set userjurisdiction=#{userjurisdiction} where id = #{userid}")
    int updateuser(@Param("userjurisdiction") int userjurisdiction, @Param("userid") int userid);


    //商品信息管理
    @Select("select * from bookInfo")
    List<BookInfoEntity> commoditylist();

    //商品所有类别信息
    @Select("select * from book_type")
    List<BookTypeEntity> selecttype();

    //修改商品信息
    @Update("update bookInfo set bookname=#{bookname},bookauthor=#{bookauthor},bookstate=#{bookstate},bookCollection=#{bookCollection} where id=#{id} ")
    int updatcommodity(@Param("bookname") String bookname, @Param("bookauthor") String bookauthor, @Param("bookstate") int bookstate, @Param("bookCollection") int bookCollection, @Param("id") int id);

    //获取一个商品的全部信息
    @Select("select * from bookInfo where id=#{id}")
    BookInfoEntity selectOneBook(@Param("id") int id);

    //删除商品信息
    @Delete("delete from bookInfo where id=#{bookid}")
    int deletecommodity(@Param("bookid") int bookid);

    //查询所有类别
    @Select("SELECT * FROM book_type")
    List<BookTypeEntity> SelectbookType();

    //新增类别
    @Insert("insert into book_type(type)values(#{type})")
    int inbooktype(String type);

    //删除类别
    @Delete("delete from book_type where id=#{id}")
    int deletebooktype(int id);
}
