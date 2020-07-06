package com.wlld.entity;

/**
 * @param
 * @DATA
 * @Author LiDaPeng
 * @Description
 */
public class Response {
    private int error;//错误码
    private String errorMessage;//错误信息
    private Object data;//信息内容

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
