package com.example.mybatis_demo.utils;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.mybatis_demo.utils.Response;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Object>> handleException(Exception e) {
        System.out.println(e);
        return ResponseEntity.status(400).body(Response.error(e.getMessage()));
    }

//    @ExceptionHandler(DataIntegrityViolationException.class) // 违反了数据库的唯一约束或完整性约束
//    public ResponseEntity<Response> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
//        return ResponseEntity.status(400).body(Response.error("请完整传入必要的参数"));
//    }

}
