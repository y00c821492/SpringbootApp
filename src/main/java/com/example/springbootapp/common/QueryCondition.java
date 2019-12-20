package com.example.springbootapp.common;

/**
 * desc:
 * author: sadcoder333
 * date: 2019/10/1
 **/
public interface QueryCondition {

    void register(String key, Object value);

    Object get(String key);
}
