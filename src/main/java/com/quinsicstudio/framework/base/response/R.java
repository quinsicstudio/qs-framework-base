package com.quinsicstudio.framework.base.response;


import com.quinsicstudio.framework.base.exception.BizException;

public class R {

    public static <T> Result<T> success() {
        return new Result<>(SystemResponse.SYS0000);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(SystemResponse.SYS0000, data);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<>(SystemResponse.SYS9999, data);
    }

    public static <T> Result<T> failRequest(T... data) {
        return new Result<>(SystemResponse.REQ9999, data);
    }

    public static <T> Result<T> error(Response response) {
        return new Result<>(response);
    }

    public static <T> Result<T> error(Response response, T data) {
        return new Result<>(response, data);
    }

    public static <T> Result<T> error(BizException e) {
        return new Result<T>(e.getResponse(), (T) e.getMessage());
    }
}
