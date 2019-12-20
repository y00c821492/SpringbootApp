package com.example.springbootapp.models;

import com.example.springbootapp.utils.JsonUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * desc: 用户数据对象
 * author: sadcoder333
 * date: 2019/11/6
 **/
public class UserDo {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("role")
    private UserRole role;

    @Override
    public String toString() {
        return JsonUtils.toString(this);
    }
}
