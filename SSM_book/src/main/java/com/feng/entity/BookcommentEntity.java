package com.feng.entity;

public class BookcommentEntity {
    //书本评论表
    private Integer id;
    private Integer userid;
    private Integer bookid;
    private String comment;
    private String commenttime;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime;
    }

    @Override
    public String toString() {
        return "BookcommentEntity{" +
                "id=" + id +
                ", userid=" + userid +
                ", bookid=" + bookid +
                ", comment='" + comment + '\'' +
                ", commenttime='" + commenttime + '\'' +
                '}';
    }
}
