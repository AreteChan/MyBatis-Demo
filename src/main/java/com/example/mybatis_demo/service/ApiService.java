package com.example.mybatis_demo.service;

import com.example.mybatis_demo.mapper.ApiMapper;
import com.example.mybatis_demo.model.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
    @Autowired
    private ApiMapper apiMapper;

    public Api getApiById(Long id) {
        return apiMapper.selectApiById(id);
    }

    public Api addApi(Api api) {
        apiMapper.insertApi(api);
        return apiMapper.selectApiById(api.getId());
    }
}
