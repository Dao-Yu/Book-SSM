package com.feng.common;

import java.util.HashMap;
import java.util.Map;

public class R {
    private Integer code;//响应状态码
    private String msg;//响应信息
    private Boolean success;
    private Map<Object,Object>data = new HashMap<>();//封装响应数据

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Map<Object, Object> getData() {
        return data;
    }

    public void setData(Map<Object, Object> data) {
        this.data = data;
    }

    private R(){

    }
    //返回响应成功的结果
    public static R ok(){
        R r = new R();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        return r;
    }
    //返回失败的结果
    public static R error(){
        R r = new R();
        r.setSuccess(ResultCodeEnum.ERROR.getSuccess());
        r.setCode(ResultCodeEnum.ERROR.getCode());
        r.setMsg(ResultCodeEnum.ERROR.getMsg());
        return r;
    }

    public static R setResult(ResultCodeEnum resultCodeEnum){
        R r = new R();
        r.setSuccess(resultCodeEnum.getSuccess());
        r.setMsg(resultCodeEnum.getMsg());
        r.setCode(resultCodeEnum.getCode());
        return r;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R msg(String msg){
        this.setMsg(msg);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R data(Object key, Object value){
        this.data.put(key,value);
        return this;
    }

    public R data(Map<Object,Object> map){
        this.setData(map);
        return this;
    }

}
