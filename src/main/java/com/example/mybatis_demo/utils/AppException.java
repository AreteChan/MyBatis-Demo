package com.example.mybatis_demo.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends RuntimeException {
    private String message;
    private int statusCode;

    public AppException(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

}
