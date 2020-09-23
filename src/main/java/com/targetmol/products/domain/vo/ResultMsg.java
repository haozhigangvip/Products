package com.targetmol.products.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ResultMsg<T> {
    private int code;
    private String msg;
    private Date timestamp;
    private T data;

    public static <T> ResultMsg<T> success() {
        return new ResultMsg<T>();
    }

    public static <T> ResultMsg<T> success(T data) {
        return new ResultMsg<T>(data);
    }

    public static <T> ResultMsg<T> error(int code, String msg) {
        return new ResultMsg<T>(code, msg);
    }

    public ResultMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.timestamp=new Date(System.currentTimeMillis());
        this.data = null;
    }

    public ResultMsg(T data) {
        this.code = 1;
        this.msg = "success";
        this.data = data;
        this.timestamp=new Date(System.currentTimeMillis());
    }

    public ResultMsg() {
        this.code = 1;
        this.msg = "success";
        this.data = null;
        this.timestamp=new Date(System.currentTimeMillis());
    }



}
