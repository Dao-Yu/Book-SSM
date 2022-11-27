package com.feng.entity;

public class UsersignatureEntity {
    //用户个性签名
    private Integer id;
    private Integer userid;
    private String signature;

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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "UsersignatureEntity{" +
                "id=" + id +
                ", userid=" + userid +
                ", signature='" + signature + '\'' +
                '}';
    }
}
