package com.polaris.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class PageResult<T> {
    @ApiModelProperty(value = "是否成功", required = true)
    private boolean success;

    @ApiModelProperty(value ="响应代码", required = true)
    private int code;

    @ApiModelProperty(value ="提示信息", required = true)
    private String msg;

    @ApiModelProperty(value ="总数量", required = true)
    private long count;

    @ApiModelProperty(value ="分页数据")
    private List<T> data;

    public PageResult(long total, List<T> rows) {
        this.count = total;
        this.data = rows;
        this.code = ResultCodeEnum.SUCCESS.code;
        this.msg = ResultCodeEnum.SUCCESS.msg;
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

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
