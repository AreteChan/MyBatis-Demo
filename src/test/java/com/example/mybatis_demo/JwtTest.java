package com.example.mybatis_demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.mybatis_demo.model.User;
import com.example.mybatis_demo.utils.JsonUtil;
import com.example.mybatis_demo.utils.JwtUtil;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class JwtTest {
     @Test
     public void testCreateToken() {
//         User user = new User("Jonny", "123@mail.com");

         String token = JwtUtil.createToken("123");

         System.out.println(token);

         System.out.println(JwtUtil.verifyToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IlwiMTIzXCIiLCJleHAiOjE3Mjc0NDU5MTJ9.t6Dr0Q17-H8eQylZyByoXnX-VxaJdu0MMbl8fnCZQRP"));

     }

}
