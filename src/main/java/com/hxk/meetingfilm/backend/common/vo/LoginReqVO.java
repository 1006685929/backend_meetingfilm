package com.hxk.meetingfilm.backend.common.vo;

import com.hxk.meetingfilm.backend.utils.common.vo.BaseRequestVO;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import com.hxk.meetingfilm.backend.utils.util.ToolUtils;
import lombok.Data;

/**
 * @author xiaokang.huang
 * @date 2020/6/5 14:22
 * @description 登陆请求对象
 */

@Data
public class LoginReqVO extends BaseRequestVO {

    private String username;
    private String password;

    @Override
    public void checkparam() throws CommonServiceException {
        // TODO 验证数据合法性
        if (ToolUtils.strIsNull(username) || ToolUtils.strIsNull(password)){
            throw new CommonServiceException(404,"用户信息不能为空");
        }
    }
}
