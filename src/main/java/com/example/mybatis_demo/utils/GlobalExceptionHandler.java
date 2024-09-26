package com.example.mybatis_demo.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.mybatis_demo.utils.Response;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Object>> handleException(Exception e) {
        log.error("💥💥💥", e);
        return ResponseEntity.status(400).body(Response.error(e.getMessage()));
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<Response<Object>> handleAppException(AppException e) {
        int statusCode = e.getStatusCode();
        return ResponseEntity.status(statusCode).body(Response.error(e.getMessage(), statusCode));
    }

//    @ExceptionHandler(DataIntegrityViolationException.class) // 违反了数据库的唯一约束或完整性约束
//    public ResponseEntity<Response> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
//        return ResponseEntity.status(400).body(Response.error("请完整传入必要的参数"));
//    }

}
