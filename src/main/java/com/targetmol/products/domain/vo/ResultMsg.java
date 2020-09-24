package com.targetmol.products.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ResultMsg<T> {
    private int code;
    private String msg;
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
        this.data = null;
    }

    public ResultMsg(T data) {
        this.code = 1;
        this.msg = "成功";
        this.data = data;
    }

    public ResultMsg() {
        this.code = 1;
        this.msg = "成功";
        this.data = null;
    }



}
