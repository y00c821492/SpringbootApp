package com.example.springbootapp.models;

import com.example.springbootapp.utils.JsonUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * desc:
 * author: yudeshui
 * date: 2019/10/1
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookInfo {

    @JsonProperty("id")
    private String id;

    @JsonProperty("bookName")
    @NotEmpty
    private String bookName;

    @JsonProperty("bookAuthor")
    @NotEmpty
    private String bookAuthor;

    @JsonProperty("bookPrice")
    @Min(0)
    private double bookPrice;

    @JsonProperty("bookIsbn")
    @NotEmpty
    private String bookIsbn;


    @Override
    public String toString() {
        return JsonUtils.toString(this);
    }
}
