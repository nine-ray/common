package com.ray.parent.common.dto;

/**
 * Created by zrc on 2020-08-24.
 */
public class ResultDto<T> {
    private Boolean success;

    private String code;

    private String message;
    private T data;


    public ResultDto(Boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultDto() {
    }


    public static ResultDto success() {
        return new ResultDto(true, "200", "success", null);
    }

    public static <T> ResultDto<T> success(T data) {
        return new ResultDto<>(true,"200","success",data);
    }

    public static <T> ResultDto<T> success(T data, String message) {
        if (message==null) {
            return success(data);
        }
        return new ResultDto<>(true,"200",message,data);
    }

    public static <T> ResultDto<T> error(String code, String message, T dataInstance) {
        return new ResultDto<>(false,code,message,dataInstance);
    }

    public static ResultDto error(String code, String message) {
        return new ResultDto(false,code,message,null);
    }
}
