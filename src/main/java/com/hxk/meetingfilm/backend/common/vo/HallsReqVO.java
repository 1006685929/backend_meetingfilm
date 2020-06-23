package com.hxk.meetingfilm.backend.common.vo;

import com.hxk.meetingfilm.backend.utils.common.vo.BasePageVO;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author xiaokang.huang
 * @date 2020/6/10 11:24
 * @description
 */

@Data
public class HallsReqVO extends BasePageVO {

    /**
     * 影院编号
     */
    private String cinemaId;


    @Override
    public void checkparam() throws CommonServiceException {

    }
}
