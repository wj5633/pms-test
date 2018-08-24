package com.wj5633.pms.util;

/**
 * @author wj
 * @create 2018-08-24 15:53
 **/
public class ResponseUtil {

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.setData(object);
        result.setCode(0);
        result.setMsg("success");
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
