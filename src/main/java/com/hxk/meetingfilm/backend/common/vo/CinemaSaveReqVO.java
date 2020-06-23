package com.hxk.meetingfilm.backend.common.vo;

import com.hxk.meetingfilm.backend.utils.common.vo.BaseRequestVO;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @author xiaokang.huang
 * @date 2020/6/9 16:41
 * @description
 */
@Data
public class CinemaSaveReqVO extends BaseRequestVO {

    /**
     * 所属品牌编号
     */
    private Integer brandId;

    /**
     * 所属地域编号
     */
    private Integer areaId;

    /**
     *所属影厅类型编号
     */
    private String hallTypeIds;

    /**
     * 影院名称
     */
    private String cinemaName;

    /**
     * 影院地址
     */
    private String cinemaAddress;

    /**
     * 影院电话
     */
    private String cinemaTele;

    /**
     * 影院主图服务器相对路径
     */
    private String cinemaImgAddress;

    /**
     * 影院最低票价
     */
    private String cinemaPrice;


    @Override
    public void checkparam() throws CommonServiceException {
    }
}
