package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.model.Api;

public interface ApiMapper {
    Api selectApiById(Long id);
    void insertApi(Api api);
    void updateApiById(Long id, Api api);
    void deleteApiById(Long id);

}
