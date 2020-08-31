package com.kamfu.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * Controller的基础返回类
 *
 * @author XiongNeng
 * @version 1.0
 * @since 2018/1/7
 */
public class BaseResponse<T> implements Serializable{
    

	/**
     * 是否成功
     */
    private HttpStatus success;

    /**
     * 说明
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public BaseResponse() {

    }

    public BaseResponse(HttpStatus success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }
    public BaseResponse(HttpStatus success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public void setSuccess(HttpStatus success) {
        this.success = success;
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
