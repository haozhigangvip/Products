package com.targetmol.products.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum  ExceptionEumn {

    AUTHORIZATION_FAILD(403,"认证失败"),
    ;
    private Integer code;
    private String message;
}
