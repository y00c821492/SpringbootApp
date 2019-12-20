package com.example.springbootapp.models.responses;

import com.example.springbootapp.base.BaseResponse;
import com.example.springbootapp.models.BookInfo;
import com.example.springbootapp.utils.JsonUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * desc: 查询图书返回结果
 * author: sadcoder333
 * date: 2019/10/1
 **/
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookInfoRsp extends BaseResponse {

    @JsonProperty("bookInfo")
    private BookInfo bookInfo;

    @Override
    public String toString() {
        return JsonUtils.toString(this);
    }
}
