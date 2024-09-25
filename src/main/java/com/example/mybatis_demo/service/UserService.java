package com.example.mybatis_demo.service;

import com.example.mybatis_demo.mapper.UserMapper;
import com.example.mybatis_demo.model.User;
import com.example.mybatis_demo.model.UserDTO;
import com.example.mybatis_demo.utils.UserConverter;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO getUserById(Long id) {

        User user = userMapper.selectUserById(id);
        return UserConverter.userToUserDTO(user);
    }

    public UserDTO addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setPassword(user.getPassword());
        userMapper.insertUser(user);
        return UserConverter.userToUserDTO(user);
    }

    public UserDTO updateUserById(Long id, Map<String, Object> updateBody) {
        userMapper.updateUserById(id, updateBody);
        User user = userMapper.selectUserById(id);
        return UserConverter.userToUserDTO(user);
    }

    public void deleteUserById(Long id) {
        userMapper.deleteUserById(id);
    }
}