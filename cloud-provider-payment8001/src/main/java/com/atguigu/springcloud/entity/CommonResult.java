package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    /**错误码*/
    private Integer code;
    /**响应信息*/
    private String message;
    /***/
    private T data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
