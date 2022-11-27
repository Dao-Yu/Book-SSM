package com.feng.entity;

import org.apache.ibatis.annotations.Insert;

import java.util.Date;

public class BookInfoEntity {
    private Integer id;//商品id
    private String bookname;//商品名称
    private String bookauthor;//作者
    private String imgUrl;//商品图片
    private String imgUrl2;//商品海报
    private double bookprice;//商品价格
    private String booktype;//商品类型
    private Integer bookamount;//库存
    private String booksynopsis;//商品简介
    private Date booktime;//商品上架时间
    private Integer bookstate;//商品发布的状态,0:未发布，1：已发布
    private Integer bookCollection;//商品被收藏数

    public BookInfoEntity() {
    }

    public BookInfoEntity(Integer id, String bookname, String bookauthor, String imgUrl, String imgUrl2, double bookprice, String booktype, Integer bookamount, String booksynopsis, Date booktime, Integer bookstate, Integer bookCollection) {
        this.id = id;
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.imgUrl = imgUrl;
        this.imgUrl2 = imgUrl2;
        this.bookprice = bookprice;
        this.booktype = booktype;
        this.bookamount = bookamount;
        this.booksynopsis = booksynopsis;
        this.booktime = booktime;
        this.bookstate = bookstate;
        this.bookCollection = bookCollection;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl2() {
        return imgUrl2;
    }

    public void setImgUrl2(String imgUrl2) {
        this.imgUrl2 = imgUrl2;
    }

    public double getBookprice() {
        return bookprice;
    }

    public void setBookprice(double bookprice) {
        this.bookprice = bookprice;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public Integer getBookamount() {
        return bookamount;
    }

    public void setBookamount(Integer bookamount) {
        this.bookamount = bookamount;
    }

    public String getBooksynopsis() {
        return booksynopsis;
    }

    public void setBooksynopsis(String booksynopsis) {
        this.booksynopsis = booksynopsis;
    }

    public Date getBooktime() {
        return booktime;
    }

    public void setBooktime(Date booktime) {
        this.booktime = booktime;
    }

    public Integer getBookstate() {
        return bookstate;
    }

    public void setBookstate(Integer bookstate) {
        this.bookstate = bookstate;
    }

    public Integer getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(Integer bookCollection) {
        this.bookCollection = bookCollection;
    }

    @Override
    public String toString() {
        return "BookInfoEntity{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", bookauthor='" + bookauthor + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", imgUrl2='" + imgUrl2 + '\'' +
                ", bookprice=" + bookprice +
                ", booktype='" + booktype + '\'' +
                ", bookamount=" + bookamount +
                ", booksynopsis='" + booksynopsis + '\'' +
                ", booktime=" + booktime +
                ", bookstate=" + bookstate +
                ", bookCollection=" + bookCollection +
                '}';
    }
}
