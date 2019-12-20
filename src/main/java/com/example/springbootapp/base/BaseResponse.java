package com.example.springbootapp.base;


import com.example.springbootapp.utils.JsonUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * desc: 基本返回信息
 * author: sadcoder333
 * date: 2019/10/1
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {

    @JsonProperty("result")
    private ResultCode resultCode;

    public long getCode() {
        return resultCode.getCode();
    }

    public String getResultMsg() {
        return resultCode.getMsg();
    }

    public void ok() {
        this.resultCode = ResultCode.SUCCESSFUL;
    }

    public boolean isSuccessful() {
        return this.resultCode == ResultCode.SUCCESSFUL;
    }


    @Override
    public String toString() {
        return JsonUtils.toString(this);
    }
}
