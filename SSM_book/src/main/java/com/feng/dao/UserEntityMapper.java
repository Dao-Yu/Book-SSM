package com.feng.dao;

import com.feng.entity.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserEntityMapper {
    /*用户登录*/
    //查询账号是否存在
    @Select("select * from user where user=#{user}")
    UserEntity login(@Param("user") String user);

    //用户注册
    @Insert("INSERT INTO USER(username,USER,PASSWORD,email,creationtime)\n" +
            "VALUES(#{username},#{user},#{password},#{email},#{creationtime});")
    int rigsht(@Param("username") String username, @Param("user") String user, @Param("password") String password,
               @Param("email") String email, @Param("creationtime") String creationtime);


    //用户收藏
    @Insert("insert into usercollect(userid,bookid) values(#{userid},#{bookid})")
    int insertUserCollect(@Param("userid") int userid, @Param("bookid") int bookid);

    //用户点击收藏时收藏数加1
    @Update("UPDATE  bookInfo SET bookCollection= bookCollection+1 WHERE id=#{bookid};")
    int updateUserCollectadd(@Param("bookid") int bookid);

    //查询用户收藏，已收藏则提醒用户已收藏
    @Select("select * from usercollect where userid=#{userid} and bookid=#{bookid}")
    UsercollectEntity usercollect(@Param("userid") int userid, @Param("bookid") int bookid);

    //用户收藏商品显示
    @Select("SELECT * FROM bookInfo WHERE id in (\n" +
            "\tSELECT bookid FROM usercollect WHERE userid=(\n" +
            "\t\tSELECT id FROM USER WHERE USER=#{user}\n" +
            "\t)\n" +
            ")")
    List<BookInfoEntity> userbookcollect(@Param("user") String user);


    //用户取消收藏
    @Delete("delete from usercollect where bookid=#{bookid}")
    int deleteuserbookcollect(@Param("bookid") int bookid);

    //用户取消收藏时收藏数减1
    @Update("UPDATE  bookInfo SET bookCollection= bookCollection-1 WHERE id=#{bookid};")
    int updateUserCollectdelete(@Param("bookid") int bookid);


    //用户点击加入购物车
    @Insert("insert into bookshooping(userid,bookid)values(#{userid},#{bookid})")
    int insertbookshopping(@Param("userid") int userid, @Param("bookid") int bookid);

    //查询用户是否已经加入购物车，已加入则提醒
    @Select("select * from bookshooping where userid=#{userid} and bookid=#{bookid}")
    BookshoopingEntity bookshopping(@Param("userid") int userid, @Param("bookid") int bookid);

    //用户购物车商品显示
    @Select("SELECT * FROM bookInfo WHERE id IN(\n" +
            "\tSELECT bookid FROM bookshooping WHERE userid=(\n" +
            "\t\tSELECT id FROM USER WHERE USER=#{user}\n" +
            "\t)\n" +
            ")")
    List<BookInfoEntity> userbookshopping(@Param("user") String user);

    //用户点击购物车中的删除，取消加入购物车
    @Delete("delete from bookshooping where bookid=#{bookid}")
    int deletebookshopping(@Param("bookid") int bookid);


    //查询当前进行修改权限的用户以便于刷新数据
    @Select("select * from user where id=#{userid}")
    UserEntity selectOnUser(@Param("userid")int userid);

    //用户修改用户名
    @Update("UPDATE USER SET username=#{newusername} WHERE id=#{userid}")
    int updateusername(@Param("userid")int userid ,@Param("newusername")String newusername);

    //查询用户收货地址信息
    @Select("SELECT * FROM useraddress WHERE userid=#{userid};")
    UseraddressEntity useraddressEntity(@Param("userid")int userid);

    //修改用户收货地址信息
    @Update("UPDATE useraddress SET address=#{address} WHERE userid = #{userid};")
    int updateaddress(@Param("address")String address,@Param("userid")int userid);

    //查询用户个性签名
    @Select("SELECT * FROM usersignature WHERE userid=#{userid};")
    UsersignatureEntity usersignatureEntity(@Param("userid")int userid);
    //用户修改个性签名
    @Update("UPDATE usersignature SET signature=#{signature} WHERE userid=#{userid};")
    int updatesignature(@Param("signature")String signature,@Param("userid")int userid);

    //用户发布动态
    @Insert("INSERT INTO dynamicissue(userid,dynamictime,dynamictype,dynamicimage)VALUES(#{userid},#{dynamictime},#{usertype},#{goodimage});")
    int addDynamic(@Param("userid")int userid,@Param("dynamictime")String dynamictime,@Param("usertype")String usertype,@Param("goodimage")String goodimage);

}
