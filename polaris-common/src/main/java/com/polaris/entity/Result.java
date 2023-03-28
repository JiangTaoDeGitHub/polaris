package com.polaris.entity;

import io.swagger.annotations.ApiModelProperty;

public class Result<T> {
    @ApiModelProperty(value = "是否成功", required = true)
    private boolean success;

    @ApiModelProperty(value ="响应代码", required = true)
    private int code;

    @ApiModelProperty(value ="提示信息", required = true)
    private String msg;

    @ApiModelProperty(value ="响应数据")
    private T data;

    /**
     *
     * @param code
     * @param data
     * @param msg
     */
    private Result(int code, T data, String msg) {
        this.success = ResultCodeEnum.SUCCESS.code == code;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     *
     * @param resultCodeEnum
     */
    private Result(ResultCodeEnum resultCodeEnum ) {
        this(resultCodeEnum.code, null, resultCodeEnum.msg);
    }

    /**
     *
     * @param resultCodeEnum
     * @param msg
     */
    private Result(ResultCodeEnum resultCodeEnum , String msg) {
        this(resultCodeEnum, null, msg);
    }

    /**
     *
     * @param resultCodeEnum
     * @param data
     */
    private Result(ResultCodeEnum resultCodeEnum , T data) {
        this(resultCodeEnum, data, resultCodeEnum.msg);
    }

    /**
     *
     * @param resultCodeEnum
     * @param data
     * @param msg
     */
    private Result(ResultCodeEnum resultCodeEnum , T data, String msg) {
        this(resultCodeEnum.code, data, msg);
    }

    /**
     *
     *
     * @param data 数据
     * @param <T>  T 响应数据
     * @
     */
    public static <T> Result<T> data(T data) {
        return data(data, ResultCodeEnum.SUCCESS.msg);
    }

    /**
     *
     *
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 响应数据
     * @
     */
    public static <T> Result<T> data(T data, String msg) {
        return data(ResultCodeEnum.SUCCESS.code, data, msg);
    }

    /**
     *
     *
     * @param code 状态码
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 响应数据
     * @
     */
    public static <T> Result<T> data(int code, T data, String msg) {
        return new Result<>(code, data, msg);
    }

    /**
     * 返回Result
     *
     * @param
     * @param <T>  T 响应数据
     * @返回Result
     */
    public static <T> Result<T> success() {
        return new Result<>(ResultCodeEnum.SUCCESS);
    }

    /**
     * 返回Result
     *
     * @param msg 消息
     * @param <T> T 响应数据
     * @返回Result
     */
    public static <T> Result<T> success(String msg) {
        return new Result<>(ResultCodeEnum.SUCCESS, msg);
    }

    /**
     * 返回Result
     *
     * @param
     * @param <T>  T 响应数据
     * @返回Result
     */
    public static <T> Result<T> success(ResultCodeEnum resultCodeEnum ) {
        return new Result<>(resultCodeEnum);
    }

    /**
     * 返回Result
     *
     * @param
     * @param msg   提示信息
     * @param <T>  T 响应数据
     * @返回Result
     */
    public static <T> Result<T> success(ResultCodeEnum resultCodeEnum , String msg) {
        return new Result<>(resultCodeEnum, msg);
    }

    /**
     * 返回Result
     *
     * @param <T> T 响应数据
     * @返回Result
     */
    public static <T> Result<T> error() {
        return new Result<>(ResultCodeEnum.ERROR, ResultCodeEnum.ERROR.msg);
    }

    /**
     * 返回Result
     *
     * @param msg 消息
     * @param <T> T 响应数据
     * @返回Result
     */
    public static <T> Result<T> error(String msg) {
        return new Result<>(ResultCodeEnum.ERROR, msg);
    }


    /**
     * 返回Result
     *
     * @param code 状态码
     * @param msg  消息
     * @param <T>  T 响应数据
     * @返回Result
     */
    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, null, msg);
    }

    /**
     * 返回Result
     *
     * @param
     * @param <T>  T 响应数据
     * @返回Result
     */
    public static <T> Result<T> error(ResultCodeEnum resultCodeEnum ) {
        return new Result<>(resultCodeEnum);
    }

    /**
     * 返回Result
     *
     * @param
     * @param msg   提示信息
     * @param <T>  T 响应数据
     * @返回Result
     */
    public static <T> Result<T> error(ResultCodeEnum resultCodeEnum , String msg) {
        return new Result<>(resultCodeEnum, msg);
    }

    /**
     *
     * @param <T>
     * @param flag
     * @return
     */
    public static <T> Result<T> result(boolean flag) {
        return flag ? Result.success("操作成功") : Result.error("操作失败");
    }


    public Result() {
    }

    public Result(boolean success, int code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
