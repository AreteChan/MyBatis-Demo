package com.example.mybatis_demo;

import com.example.mybatis_demo.utils.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import com.example.mybatis_demo.model.User;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MybatisDemoApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testSaveObject() throws JsonProcessingException {
        User user = new User("Jonny", "1234@mail.com");

        // 序列化
        String userJSON = JsonUtil.toJson(user);
        // 写入redis
        stringRedisTemplate.opsForValue().set("userObj", userJSON);
        // 读取redis
        String userJSON2 = stringRedisTemplate.opsForValue().get("userObj");

        // 反序列化
        User user2 = JsonUtil.toObject(userJSON2, User.class);
        System.out.println(user2);
    }

    @Test
    void testSaveName() {
        stringRedisTemplate.opsForValue().set("name", "Jonny");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
    }

    @Test
    void testSaveHash() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Jonny");
        map.put("email", "123@mail.com");

        stringRedisTemplate.opsForHash().putAll("userMap", map);
        Map newMap = stringRedisTemplate.opsForHash().entries("userMap");

        System.out.println(newMap.get("name"));
    }


}
