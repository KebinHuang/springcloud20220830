package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //返回成功的编码
    private Integer code;
    //返回给前端的信息
    private String message;
    //返回给前端的数据
    private T data;
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
