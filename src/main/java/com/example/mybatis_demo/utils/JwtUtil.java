package com.example.mybatis_demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
@Slf4j
public class JwtUtil {

    private static final String SECRET = "jwt_secret";
    private static final int EXPIRE = 3600 * 30 * 1000;

    public static String createToken(String id) {
        return JWT.create()
                .withClaim("id", id)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE))
                .sign(Algorithm.HMAC256(SECRET));
    }

    public static String verifyToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token).getClaim("id").asString();
        } catch (Exception e) {
            log.error("💥💥💥", e);
            throw new AppException("token验证失败", 401);
        }
    }
}
