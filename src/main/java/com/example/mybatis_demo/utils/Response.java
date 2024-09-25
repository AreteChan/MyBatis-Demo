package com.example.mybatis_demo.utils;

public class Response <T>{

    private int statusCode;
    private String status;
    private T data;

    private String errorMessage;

    public Response(int statusCode, String status, T data) {
        this.statusCode = statusCode;
        this.status = status;
        this.data = data;
    }

    public Response(int statusCode, String status, String errorMessage) {
        this.statusCode = statusCode;
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(200, "success", data);
    }

    public static <T> Response<T> success(T data, int statusCode) {
        return new Response<>(statusCode, "success", data);
    }

    public static <T> Response<T> error(String errorMessage) {
        return new Response<>(400, "error", errorMessage);
    }

    public static <T> Response<T> error(String errorMessage, int statusCode) {
        return new Response<>(statusCode, "error", errorMessage);
    }
}
