package com.zmj.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZMJ
 * @Package com.zmj
 * @date 2023/10/12 15:45
 */
@Data
public class Result<T> implements Serializable {

    private Result() {
    }

    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    public static Result ok() {
        Result<Object> result = new Result<>();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(ResultMessage.SUCCESS);
        return result;
    }

    public static Result ok(Integer resultCode, String resultMessage) {
        Result<Object> result = new Result<>();
        result.setSuccess(true);
        result.setCode(resultCode);
        result.setMessage(resultMessage);
        return result;
    }

    public static <T> Result ok(Integer resultCode, String resultMessage, T data) {
        Result<Object> result = new Result<>();
        result.setSuccess(true);
        result.setCode(resultCode);
        result.setMessage(resultMessage);
        result.setData(data);
        return result;
    }

    public static <T> Result ok(T data) {
        Result<Object> result = new Result<>();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(ResultMessage.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result fail() {
        Result<Object> result = new Result<>();
        result.setSuccess(true);
        result.setCode(ResultCode.ERROR);
        result.setMessage(ResultMessage.ERROR);
        return result;
    }

    public static Result fail(Integer resultCode, String resultMessage) {
        Result<Object> result = new Result<>();
        result.setSuccess(true);
        result.setCode(resultCode);
        result.setMessage(resultMessage);
        return result;
    }

    public static <T> Result fail(Integer resultCode, String resultMessage, T data) {
        Result<Object> result = new Result<>();
        result.setSuccess(true);
        result.setCode(resultCode);
        result.setMessage(resultMessage);
        result.setData(data);
        return result;
    }

    public static <T> Result fail(T data) {
        Result<Object> result = new Result<>();
        result.setSuccess(true);
        result.setCode(ResultCode.ERROR);
        result.setMessage(ResultMessage.ERROR);
        result.setData(data);
        return result;
    }

}
