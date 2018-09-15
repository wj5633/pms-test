package com.wj5633.pms.exception;

import com.wj5633.pms.wrapper.response.WebApiResponse;
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
    public WebApiResponse errorHandler(Exception ex) {
        return WebApiResponse.error(ex.getMessage());
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public WebApiResponse myErrorHandler(MyException ex) {
        return WebApiResponse.error(ex.getMsg(), ex.getCode());
    }
}
