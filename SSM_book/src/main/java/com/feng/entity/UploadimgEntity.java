package com.feng.entity;

public class UploadimgEntity {
    //存放图片的信息
    private boolean state;
    private String msg;
    private String url;
    private String url2;


    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public UploadimgEntity() {
    }

    public UploadimgEntity(boolean state, String msg, String url, String url2) {
        this.state = state;
        this.msg = msg;
        this.url = url;
        this.url2 = url2;
    }

    @Override
    public String toString() {
        return "UploadimgEntity{" +
                "state=" + state +
                ", msg='" + msg + '\'' +
                ", url='" + url + '\'' +
                ", url2='" + url2 + '\'' +
                '}';
    }
}
