package com.example.springbootapp.common;

import java.util.HashMap;
import java.util.Map;

/**
 * desc: 默认查询条件实现
 * author: sadcoder333
 * date: 2019/10/1
 **/
public class DefaultQueryCondition implements QueryCondition {

    private Map<String, Object> condition;

    public DefaultQueryCondition() {
        condition = new HashMap<>(Constants.MAP_SIZE);
    }

    @Override
    public void register(String key, Object value) {
        if (!condition.containsKey(key)) {
            condition.put(key, value);
        }
    }

    @Override
    public Object get(String key) {
        return condition.get(key);
    }
}
