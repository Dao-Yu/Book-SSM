package com.feng.entity;

import java.util.Date;

public class UploadimgFileEntity {
    private Integer id;//图片id
    private String oldNmae;//上传前的名字
    private String newName;//上传后的名字
    private String contentType;//文件类型
    private String imgurl;//图片路径
    private String imgurl2;
    private Date uploadTime;//上传时间

    public UploadimgFileEntity() {
    }

    public UploadimgFileEntity(Integer id, String oldNmae, String newName, String contentType, String imgurl, String imgurl2, Date uploadTime) {
        this.id = id;
        this.oldNmae = oldNmae;
        this.newName = newName;
        this.contentType = contentType;
        this.imgurl = imgurl;
        this.imgurl2 = imgurl2;
        this.uploadTime = uploadTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOldNmae() {
        return oldNmae;
    }

    public void setOldNmae(String oldNmae) {
        this.oldNmae = oldNmae;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getImgurl2() {
        return imgurl2;
    }

    public void setImgurl2(String imgurl2) {
        this.imgurl2 = imgurl2;
    }

    @Override
    public String toString() {
        return "UploadimgFileEntity{" +
                "id=" + id +
                ", oldNmae='" + oldNmae + '\'' +
                ", newName='" + newName + '\'' +
                ", contentType='" + contentType + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", imgurl2='" + imgurl2 + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
