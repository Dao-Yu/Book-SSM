package com.feng.entity;

public class UsercollectEntity {
    //收藏表
    private Integer id;
    private Integer userid;
    private Integer bookid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    @Override
    public String toString() {
        return "UsercollectEntity{" +
                "id=" + id +
                ", userid=" + userid +
                ", bookid=" + bookid +
                '}';
    }
}
