package com.yuantek.vo;

import lombok.Getter;

/**
 * 根据项目自定义,可以延用并扩展HTTP状态码,也可以使用0,1,2
 * 本项目 0就代表成功
 */
@Getter
public enum ResponseCode {

    SUCCESS(0, "成功"),
    ERROR(1, "失败");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
