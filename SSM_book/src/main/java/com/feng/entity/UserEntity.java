package com.feng.entity;

import java.util.List;

public class UserEntity {
    //用户信息
    private int id;
    private String username;
    private String userimg;
    private String user;
    private String password;
    private String email;
    private String creationtime;
    private int userjurisdiction;

    //评论
    private List<BookcommentEntity> comment;

    //动态
    private List<UserDynamicissueEutity> dynamicissueEutityList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime;
    }

    public int getUserjurisdiction() {
        return userjurisdiction;
    }

    public void setUserjurisdiction(int userjurisdiction) {
        this.userjurisdiction = userjurisdiction;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public List<BookcommentEntity> getComment() {
        return comment;
    }

    public void setComment(List<BookcommentEntity> comment) {
        this.comment = comment;
    }

    public List<UserDynamicissueEutity> getDynamicissueEutityList() {
        return dynamicissueEutityList;
    }

    public void setDynamicissueEutityList(List<UserDynamicissueEutity> dynamicissueEutityList) {
        this.dynamicissueEutityList = dynamicissueEutityList;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userimg='" + userimg + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", creationtime='" + creationtime + '\'' +
                ", userjurisdiction=" + userjurisdiction +
                ", comment=" + comment +
                ", dynamicissueEutityList=" + dynamicissueEutityList +
                '}';
    }
}
