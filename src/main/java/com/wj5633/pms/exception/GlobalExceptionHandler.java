package com.wj5633.pms.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wj
 * @create 2018-09-06 21:58
 **/

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, String> errorHandler(Exception e) {
        Map<String, String> map = new HashMap<>();
        map.put("error", "Global error" + e.getClass().getName());

        return map;
    }
}
