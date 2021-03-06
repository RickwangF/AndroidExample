package com.example.androidtest.network;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rick on 2018/4/9.
 */

public class HttpResponse<T> {

    @SerializedName("code")
    private int Code;

    @SerializedName("message")
    private String Message;

    @SerializedName("data")
    private T Data;

    @SerializedName("cache")
    private String Cache;

    public HttpResponse() {
    }

    public HttpResponse(int code, String message, T data, String cache) {
        Code = code;
        Message = message;
        Data = data;
        Cache = cache;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public String getCache() {
        return Cache;
    }

    public void setCache(String cache) {
        Cache = cache;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "Code=" + Code +
                ", Message='" + Message + '\'' +
                ", Data=" + Data +
                ", Cache='" + Cache + '\'' +
                '}';
    }
}
