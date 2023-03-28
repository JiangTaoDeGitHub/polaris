package com.polaris.exception;

import com.polaris.entity.ResultCodeEnum;

/**
 * @ClassName: BusinessException
 * @Description: 业务处理异常
 * @author jiangtao
 * @date
 */
public class BusinessException extends RuntimeException{

    private int code;

    private String msg;

    public BusinessException() {
        this.code = ResultCodeEnum.FAILED.code;
        this.msg = ResultCodeEnum.FAILED.msg;
    }

    public BusinessException(String message) {
        this.code = ResultCodeEnum.FAILED.code;
        this.msg = message;
    }

    public BusinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
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
}
