package com.hxk.meetingfilm.backend.common.vo;

import lombok.Data;

/**
 * @author xiaokang.huang
 * @date 2020/6/8 16:04
 * @description 影片列表接口返回对象
 */

@Data
public class FilmsRespVO {

    /**
     * 影片id
     */
    private String filmId;
    private String filmStatus;
    private String filmName;
    private String filmEnName;
    private String filmScore;
    private String preSaleNum;
    private String boxOffice;
    private String filmTime;
    private String filmLength;
    private String mainImg;
}
