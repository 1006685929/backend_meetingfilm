package com.hxk.meetingfilm.backend.common.vo;

import com.hxk.meetingfilm.backend.utils.common.vo.BaseRequestVO;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author xiaokang.huang
 * @date 2020/6/10 11:43
 * @description
 */

@Data
public class HallSavedReqVO extends BaseRequestVO {

    private String cinemaId;
    private String filmId;
    private String hallTypeId;
    private String beginTime;
    private String endTime;
    private String filmPrice;
    private String hallName;

    @Override
    public void checkparam() throws CommonServiceException {

    }
}
