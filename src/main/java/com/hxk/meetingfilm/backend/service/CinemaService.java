package com.hxk.meetingfilm.backend.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hxk.meetingfilm.backend.common.vo.AllCinemaRespVO;
import com.hxk.meetingfilm.backend.common.vo.CinemaSaveReqVO;
import com.hxk.meetingfilm.backend.dao.entity.FilmCinemaT;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;

/**
 * @author xiaokang.huang
 * @date 2020/6/9 16:37
 * @description 影院模块服务层
 */

public interface CinemaService {

    /**
     * 添加影院
     * @param cinemaSaveReqVO
     */
    void createCinema(CinemaSaveReqVO cinemaSaveReqVO) throws CommonServiceException;

    /**
     * 获取影院列表
     * @param nowPage
     * @param pageSize
     * @return
     * @throws CommonServiceException
     */
    IPage<AllCinemaRespVO> allCinemas(int nowPage, int pageSize) throws CommonServiceException;

    /**
     * 根据id查询影院
     * @param cinemaId
     * @return
     * @throws CommonServiceException
     */
    FilmCinemaT selectCinemaById(String cinemaId) throws CommonServiceException;

    /**
     * 修改影院信息
     * @param cinemaT
     * @throws CommonServiceException
     */
    void updateCinema(FilmCinemaT cinemaT) throws CommonServiceException;

    /**
     * 删除影院
     * @param cinemaId
     */
    void deleteCinema(String cinemaId);

}
