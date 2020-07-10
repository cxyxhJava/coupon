package com.frank.config;

import com.frank.common.ClientException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 16:27 2020-06-26
 * @ Description：自定义异常处理器
 * @ Modified By：
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();

        if (e instanceof ClientException){
            map.put("code",((ClientException) e).getHttpStatusCode());
            map.put("message",((ClientException) e).getMsg());
        }else if (e instanceof MethodArgumentNotValidException){
            map.put("code",400);
            map.put("message",((MethodArgumentNotValidException) e).getBindingResult().getTarget().toString());
        }
        else {
            map.put("code","500");
            map.put("message","系统异常");
        }
        return map;
    }
}

