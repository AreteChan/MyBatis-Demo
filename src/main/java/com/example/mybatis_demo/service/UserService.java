package com.example.mybatis_demo.service;

import com.example.mybatis_demo.mapper.UserMapper;
import com.example.mybatis_demo.model.User;
import com.example.mybatis_demo.model.UserDTO;
import com.example.mybatis_demo.utils.AppException;
import com.example.mybatis_demo.utils.JwtUtil;
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
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
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

    public String login(User user) {
        // 从数据库中查找用户
        User userInDB = userMapper.selectUserByEmail(user.getEmail());
        // 判断用户是否存在，且密码是否正确
        if (userInDB != null && userInDB.getPassword().equals(user.getPassword())) {
            Long id = userInDB.getId();
            return JwtUtil.createToken(id.toString());
        } else {
            throw new AppException("用户名或密码错误", 400);
        }
    }
}