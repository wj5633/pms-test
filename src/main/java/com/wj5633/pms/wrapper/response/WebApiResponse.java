package com.wj5633.pms.wrapper.response;

/**
 * @author wj
 * @create 2018-09-08 16:43
 **/
public class WebApiResponse<T> {
    public static final int SUCCESS_CODE = 0;
    public static final int ERROR_CODE = 1;

    private int code;
    private String error;
    private T data;

    public static <T> WebApiResponse<T> success(T data) {
        WebApiResponse<T> response = new WebApiResponse<>();
        response.setCode(SUCCESS_CODE);
        response.setData(data);
        return response;
    }

    public static <T> WebApiResponse<T> error(String error) {
        return WebApiResponse.error(error, ERROR_CODE);
    }

    public static <T> WebApiResponse<T> error(String error, int errorCode) {
        WebApiResponse<T> response = new WebApiResponse<>();
        response.setCode(errorCode);
        response.setError(error);
        return response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
