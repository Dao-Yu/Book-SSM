package com.feng.entity;

public class UseraddressEntity {
    //用户收货地址
    private Integer id;
    private Integer userid;
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UseraddressEntity{" +
                "id=" + id +
                ", userid=" + userid +
                ", address='" + address + '\'' +
                '}';
    }
}
