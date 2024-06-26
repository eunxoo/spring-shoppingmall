package com.example.shoppingmall.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ApiUtils {
    public static <T> ApiResult<T> success(T data) {
        return new ApiResult(true, data, null);
    }

    public static <T> ApiResult<T> success(T data,HttpStatus httpStatus) {
        return new ApiResult(true, data, httpStatus, null);
    }

    public static <M> ApiResult<M> error(M message, HttpStatus httpStatus) {
        return new ApiResult(false,
                null,
                new ApiError(message, httpStatus));
    }

    @Getter
    @AllArgsConstructor
    public static class ApiResult<T> {

        boolean success;
        T response;
        HttpStatus httpStatus;
        ApiError error;

        public ApiResult(boolean success, T response, ApiError error) {
            this.success = success;
            this.response = response;
            this.error = error;
        }
    }

    @Getter
    public static class ApiError<M> {
        M message;
        HttpStatus httpStatus;

        ApiError(M message, HttpStatus httpStatus) {
            this.message = message;
            this.httpStatus = httpStatus;
        }
    }
}



