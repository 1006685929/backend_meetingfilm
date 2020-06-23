package com.hxk.meetingfilm.backend.utils.common.vo;

import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author xiaokang.huang
 * @date 2020/6/8 15:32
 * @description 分页请求类
 */
@Data
public class BasePageVO extends BaseRequestVO{

    private Integer nowPage = 1;
    private Integer pageSize = 10;

    @Override
    public void checkparam() throws CommonServiceException {
        // TODO nowpage和pageSize不能为空
    }
}
