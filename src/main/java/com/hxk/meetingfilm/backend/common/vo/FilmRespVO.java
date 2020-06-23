package com.hxk.meetingfilm.backend.common.vo;

import lombok.Data;

/**
 * @author xiaokang.huang
 * @date 2020/6/8 16:12
 * @description 根据主键获取影片信息返回对象
 */

@Data
public class FilmRespVO {

    private String filmId;
    private String filmName;
    private String filmLength;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private String subAddress;
}
