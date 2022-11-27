package com.feng.entity;

public class UserDynamicissueEutity {
    //用户动态信息
    private Integer id;
    private Integer userid;
    private String dynamictime;
    private String dynamictype;
    private String dynamicimage;
    private Integer tags;
    private Integer transmit;


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

    public String getDynamictime() {
        return dynamictime;
    }

    public void setDynamictime(String dynamictime) {
        this.dynamictime = dynamictime;
    }

    public String getDynamictype() {
        return dynamictype;
    }

    public void setDynamictype(String dynamictype) {
        this.dynamictype = dynamictype;
    }

    public String getDynamicimage() {
        return dynamicimage;
    }

    public void setDynamicimage(String dynamicimage) {
        this.dynamicimage = dynamicimage;
    }

    public Integer getTags() {
        return tags;
    }

    public void setTags(Integer tags) {
        this.tags = tags;
    }

    public Integer getTransmit() {
        return transmit;
    }

    public void setTransmit(Integer transmit) {
        this.transmit = transmit;
    }

    @Override
    public String toString() {
        return "UserDynamicissueEutity{" +
                "id=" + id +
                ", userid=" + userid +
                ", dynamictime='" + dynamictime + '\'' +
                ", dynamictype='" + dynamictype + '\'' +
                ", dynamicimage='" + dynamicimage + '\'' +
                ", tags=" + tags +
                ", transmit=" + transmit +
                '}';
    }
}
