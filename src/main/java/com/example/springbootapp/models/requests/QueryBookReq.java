package com.example.springbootapp.models.requests;

import com.example.springbootapp.utils.JsonUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * desc: 查询图书请求类
 * author: yudeshui
 * date: 2019/10/1
 **/
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryBookReq {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("author")
    private String author;

    @JsonProperty("price")
    private double price;

    @JsonProperty("isbn")
    private String isbn;


    @Override
    public String toString() {
        return JsonUtils.toString(this);
    }
}
