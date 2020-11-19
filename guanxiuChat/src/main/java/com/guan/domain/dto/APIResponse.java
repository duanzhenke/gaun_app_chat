package com.guan.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;


public class APIResponse<T> {
    //状态码
    private int code;
    //状态码"状态信息")
    private String msg;
    //状态码"返回数据")
    private T data;
    //状态码"附加数据"
    private Map<String, Object> ext;

    private APIResponse() {
        this.ext = new HashMap();
        this.code = 1;
        this.msg = "成功";
    }

    private APIResponse(T data) {
        this();
        this.data = data;
    }

    private APIResponse(int code, String msg) {
        this(code, msg, null);
    }

    private APIResponse(int code, String msg, T data) {
        this.ext = new HashMap();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static APIResponse success() {
        return new APIResponse();
    }

    public static <T> APIResponse<T> success(T data) {
        return new APIResponse(data);
    }

    public static APIResponse success(String msg) {
        return new APIResponse(1, msg, (Object) null);
    }

    public static <T> APIResponse<T> success(String msg, T data) {
        return new APIResponse(1, msg, data);
    }

    public static <T> APIResponse<T> error(int code, String msg, T data) {
        return new APIResponse(code, msg, data);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return 1 == this.code;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public void setExt(final Map<String, Object> ext) {
        this.ext = ext;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public Map<String, Object> getExt() {
        return this.ext;
    }
}
