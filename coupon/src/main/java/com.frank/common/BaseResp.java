package com.frank.common;

import lombok.Builder;
import lombok.Data;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:25 2020-05-28
 * @ Description：
 * @ Modified By：
 */
@Data
@Builder
public class BaseResp<T> {

    private T data;

    private Integer code;

    private String message;

}
