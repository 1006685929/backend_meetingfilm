package com.hxk.meetingfilm.backend.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hxk.meetingfilm.backend.common.vo.HallSavedReqVO;
import com.hxk.meetingfilm.backend.common.vo.HallsReqVO;
import com.hxk.meetingfilm.backend.common.vo.HallsRespVO;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;

/**
 * @author xiaokang.huang
 * @date 2020/6/10 11:18
 * @description
 */

public interface HallService {

    /**
     * 分页获取播放厅列表
     * @return
     * @throws CommonServiceException
     */
    IPage<HallsRespVO> selectAllHalls(HallsReqVO hallsReqVO) throws CommonServiceException;

    /**
     * 新增影厅
     * @param hallSavedReqVO
     * @throws CommonServiceException
     */
    void createHall(HallSavedReqVO hallSavedReqVO) throws CommonServiceException;
}
