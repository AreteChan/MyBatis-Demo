package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;


public interface UserMapper {
    User selectUserById(Long id);
    void insertUser(User user);

    void updateUserById(@Param("id") Long id, @Param("updateBody") Map<String, Object> updateBody);

    void deleteUserById(Long id);
}
