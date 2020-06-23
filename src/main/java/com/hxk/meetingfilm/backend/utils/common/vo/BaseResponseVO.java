package com.hxk.meetingfilm.backend.utils.common.vo;

import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author xiaokang.huang
 * @date 2020/6/5 11:07
 * @description
 */

@Data
public class BaseResponseVO<M> {

    /**
     * 业务编码
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String message;

    /**
     * 业务数据返回
     */
    private M data;

    private BaseResponseVO(){};

    /**
     * 成功但是无参
     * @return
     */
    public static BaseResponseVO success(){
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(200);
        response.setMessage("");
        return response;
    }

    /**
     * 成功但是有参数
     * @param data
     * @param <M>
     * @return
     */
    public static<M> BaseResponseVO success(M data){
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(200);
        response.setMessage("");
        response.setData(data);
        return response;
    }

    /**
     * 失败返回
     * @param e
     * @param <M>
     * @return
     */
    public static<M> BaseResponseVO serviceException(CommonServiceException e){
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(e.getCode());
        response.setMessage(e.getMessage());
        return response;
    }

    /**
     * 未登录异常
     * @param <M>
     * @return
     */
    public static<M> BaseResponseVO noLogin(){
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(401);
        response.setMessage("请登录");
        return response;
    }


}
