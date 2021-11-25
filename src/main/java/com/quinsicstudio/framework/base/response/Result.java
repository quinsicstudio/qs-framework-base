package com.quinsicstudio.framework.base.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Arrays;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {

    private Response response;
    private T data;

    public Result (Response response, T data) {
        this.response = response;
        this.data = data;
    }

    public Result (Response response, T... data) {
        this.response = response;
        this.data = (T) Arrays.asList(data);
    }

    public Result(Response response) {
        this.response = response;
    }
}
