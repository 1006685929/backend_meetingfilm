package com.hxk.meetingfilm.backend.utils.exception;

import lombok.Data;

/**
 * @author xiaokang.huang
 * @date 2020/6/5 14:34
 * @description 公共业务逻辑错误
 */

@Data
public class CommonServiceException extends Exception {

    /**
     * 编码
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    public CommonServiceException(int code,String message){
        this.code = code;
        this.message = message;
    }

}

