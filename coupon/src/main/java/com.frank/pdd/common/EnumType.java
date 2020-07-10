package com.frank.pdd.common;

import lombok.Data;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 13:42 2020-06-25
 * @ Description：类型
 * @ Modified By：
 */
public enum  EnumType {
    PDD(1,"拼多多"),
    TBK(2,"淘宝客")
    ;

    EnumType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    private Integer code;

    private String value;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }}
