package com.hxk.meetingfilm.backend.common.vo;

import lombok.Data;

/**
 * @author xiaokang.huang
 * @date 2020/6/9 16:58
 * @description 影院返回参数VO
 */

@Data
public class AllCinemaRespVO {

    private String brandId;
    private String areaId;
    private String hallTypeIds;
    private String cinemaName;
    private String cinemaAddress;
    private String cinemaTele;
    private String cinemaImgAddress;
    private String cinemaPrice;
}
