package com.example.mybatis_demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Api {
    private long id;
    @NonNull
    private String name;
    private State state;
    private Method method;
    private String path;
    private Date createdTime;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long creatorId;  // 外键
//    private String creatorName;

    private UserDTO creator;

}

enum State {
    DEVELOPED, FINISHED
}

enum Method {
    GET, POST, PUT, PATCH, DELETE
}