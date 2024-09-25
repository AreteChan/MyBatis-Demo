package com.example.mybatis_demo.controller;

import com.example.mybatis_demo.model.Api;
import com.example.mybatis_demo.model.UserDTO;
import com.example.mybatis_demo.service.ApiService;
import com.example.mybatis_demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private ApiService apiService;

    @GetMapping("/{id}")
    public Response<Api> getApi(@PathVariable Long id) {
        return Response.success(apiService.getApiById(id));
    }

    @PostMapping
    public Response<Api> addApi(@RequestBody Api api) {
        return Response.success(apiService.addApi(api), 201);
    }

}
