package com.hxk.meetingfilm.backend.common.vo;


import com.hxk.meetingfilm.backend.utils.common.vo.BaseRequestVO;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author xiaokang.huang
 * @date 2020/6/8 16:26
 * @description 添加影片信息对象
 */

@Data
public class FilmSavedReqVO extends BaseRequestVO {

    private String filmStatus;
    private String filmName;
    private String filmEnName;
    private String mainImgAddress;
    private String filmScore;
    private String filmScorers;
    private String preSaleNum;
    private String boxOffice;
    private String filmTypeId;
    private String filmSourceId;
    private String filmCatIds;
    private String areaId;
    private String dateId;
    private String filmTime;
    private String directorId;
    private String actIds;      // actIds与RoleNames是不是能在数量上对应上
    private String roleNames;
    private String filmLength;
    private String biography;
    private String filmImgs;

    @Override
    public void checkparam() throws CommonServiceException {
        
    }
}
