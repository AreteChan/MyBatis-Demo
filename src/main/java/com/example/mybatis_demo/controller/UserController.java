package com.example.mybatis_demo.controller;

import com.example.mybatis_demo.model.UserDTO;
import com.example.mybatis_demo.utils.Response;
import com.example.mybatis_demo.model.User;
import com.example.mybatis_demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("根据id获取用户")
    @GetMapping("/{id}")
    public Response<UserDTO> getUser(@PathVariable Long id) {
        return Response.success(userService.getUserById(id));
    }

    @PostMapping
    public Response<UserDTO> addUser(@RequestBody User user) {
        return Response.success(userService.addUser(user), 201);
    }

    @PatchMapping("/{id}")
    public Response<UserDTO> updateUser(@PathVariable Long id, @RequestBody Map<String, Object> updateBody) {
        return Response.success(userService.updateUserById(id, updateBody));
    }

    @DeleteMapping("/{id}")
    public Response<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return Response.success(null, 204);
    }

    @PostMapping("/login")
    public Response<String> login(@RequestBody User user) {
        return Response.success(userService.login(user));
    }
}

