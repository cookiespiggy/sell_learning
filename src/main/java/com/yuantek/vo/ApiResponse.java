package com.yuantek.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

import java.io.Serializable;

/**
 * 根据项目前端接口API来定制
 * (也可以理解为最外层包装对象)
 *
 * @param <T>
 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)//只序列化不为空的属性
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ApiResponse<T> implements Serializable {

    /** 状态码 */
    private Integer code;

    /** 提示信息,状态描述 */
    private String msg;

    /** 具体内容 */
    private T data;

    public ApiResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @JsonIgnore // 不序列化此属性
    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    // 有时候,我们仅仅需要一个错误的提示
    public static <T> ApiResponse<T> createByError() {
        return new ApiResponse<>(ResponseCode.ERROR.getCode(), null,null);
    }

    // 有时候,我们仅仅需要一个正确的提示
    public static <T> ApiResponse<T> createBySuccess() {
        return new ApiResponse<>(ResponseCode.SUCCESS.getCode(),null,null);
    }

    // 有时候,我们需要手动输入错误信息,需要调用这个方法
    public static <T> ApiResponse<T> createByErrorMessage(String errorMessage) {
        return new ApiResponse<>(ResponseCode.ERROR.getCode(), errorMessage,null);
    }

    // 有时候,我们需要手动输入成功信息,需要调用这个方法
    public static <T> ApiResponse<T> createBySuccessMessage(String msg) {
        return new ApiResponse<>(ResponseCode.SUCCESS.getCode(), msg,null);
    }

    public static <T> ApiResponse<T> createBySuccess(T data) {
        return new ApiResponse<>(ResponseCode.SUCCESS.getCode(),null,data);
    }

    public static <T> ApiResponse<T> createBySuccess(String msg, T data) {
        return new ApiResponse<>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    // 比如强制登录的场景下使用
    public static <T> ApiResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new ApiResponse<>(errorCode, errorMessage,null);
    }

}
