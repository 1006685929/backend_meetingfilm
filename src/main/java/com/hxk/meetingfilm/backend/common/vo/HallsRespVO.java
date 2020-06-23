package com.hxk.meetingfilm.backend.common.vo;

import lombok.Data;

/**
 * @author xiaokang.huang
 * @date 2020/6/10 11:29
 * @description
 */

@Data
public class HallsRespVO {

    private String cinemaName;
    private String hallName;
    private String filmName;
    private String hallTypeName;
    private String beginTime;
    private String endTime;
    private String filmPrice;
}
