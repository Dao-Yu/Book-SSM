package com.feng.common;

public enum ResultCodeEnum {
    /*枚举值*/
    SUCCESS(true,"成功",200),
    ERROR(false,"失败",400);


    private Boolean success;
    private String msg;
    private Integer code;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    ResultCodeEnum(Boolean success, String msg, Integer code) {
        this.success = success;
        this.msg = msg;
        this.code = code;
    }
}
