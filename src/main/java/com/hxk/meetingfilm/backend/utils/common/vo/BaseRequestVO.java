package com.hxk.meetingfilm.backend.utils.common.vo;


import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;

/**
 * @author xiaokang.huang
 * @date 2020/6/5 14:26
 * @description 公共请求对象
 */

public abstract class BaseRequestVO {

    /**
     * 公共的参数验证方法
     */
    public abstract void checkparam() throws CommonServiceException;
}
