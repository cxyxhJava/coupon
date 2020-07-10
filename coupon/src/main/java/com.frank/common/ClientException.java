package com.frank.common;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 16:22 2020-06-26
 * @ Description：
 * @ Modified By：
 */
@Data
public class ClientException extends Exception {
    private Integer httpStatusCode;
    private String msg;

    /*无参构造函数*/
    public ClientException(){
        super();
    }

    //用详细信息指定一个异常
    public ClientException(String message){
        super(message);
    }

    //用指定的详细信息和原因构造一个新的异常
    public ClientException(String message, Throwable cause){
        super(message,cause);
    }

    //用指定原因构造一个新的异常
    public ClientException(Throwable cause) {
        super(cause);
    }

    public ClientException(Integer httpStatusCode, String msg, Throwable e) {
        super(msg);
        boolean httpStausCode = httpStatusCode >= 400;
        if (!httpStausCode) {
            throw new RuntimeException("默认客户端错误状态码应该大于等于400");
        } else {
            this.setMsg(msg);
            this.setHttpStatusCode(httpStatusCode);
            if (e != null) {
                try {
                    Field field = this.getClass().getSuperclass().getSuperclass().getSuperclass().getSuperclass().getSuperclass().getDeclaredField("cause");
                    if (field != null) {
                        field.setAccessible(true);

                        try {
                            field.set(this, e);
                        } catch (IllegalAccessException var7) {
                        }
                    }
                } catch (NoSuchFieldException var8) {
                }
            }
        }
    }
}
