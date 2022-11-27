package com.feng.dao;

import com.feng.entity.BookInfoEntity;
import com.feng.entity.UploadimgFileEntity;
import org.apache.ibatis.annotations.Insert;

public interface UploadimgFileEntityMapper {
    //存储上传记录信息
    @Insert("insert into imgupload values(default,#{oldNmae},#{newName},#{contentType},#{imgurl},#{imgurl2},now())")
    int inUploadimgFileEntityMapper(UploadimgFileEntity uploadimgFileEntity);

    //新增商品信息
    @Insert("insert into bookInfo(bookname,bookauthor,bookprice,booktype,bookamount,imgurl,imgurl2,booksynopsis,booktime) " +
            "values" +
            "(#{bookname},#{bookauthor},#{bookprice},#{booktype},#{bookamount},#{imgUrl},#{imgUrl2},#{booksynopsis},now())")
    int inbookInfoService(BookInfoEntity bookInfoEntity);
}
