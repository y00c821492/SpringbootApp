package com.example.springbootapp.models.responses;

import com.example.springbootapp.base.BaseResponse;
import com.example.springbootapp.models.BookInfo;
import com.example.springbootapp.utils.JsonUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/**
 * desc:
 * author: sadcoder333
 * date: 2019/10/1
 **/
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryBookRsp extends BaseResponse {

    @JsonProperty("bookList")
    private List<BookInfo> bookList;

    @Override
    public String toString() {
        return JsonUtils.toString(this);
    }
}
