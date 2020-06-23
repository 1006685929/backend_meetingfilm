package com.hxk.meetingfilm.backend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hxk.meetingfilm.backend.common.vo.ActorsRespVO;
import com.hxk.meetingfilm.backend.common.vo.FilmRespVO;
import com.hxk.meetingfilm.backend.common.vo.FilmSavedReqVO;
import com.hxk.meetingfilm.backend.common.vo.FilmsRespVO;
import com.hxk.meetingfilm.backend.utils.common.vo.BaseResponseVO;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xiaokang.huang
 * @date 2020/6/8 15:56
 * @description 影片逻辑层
 */

public interface FilmService {

    /**
     * 获取演员列表
     * @param nowPage
     * @param pageSize
     * @return
     * @throws CommonServiceException
     */
    IPage<ActorsRespVO> allActors(int nowPage, int pageSize) throws CommonServiceException;

    /**
     * 获取影片列表
     * @param nowPage
     * @param pageSize
     * @return
     */
    IPage<FilmsRespVO> allFilms(Integer nowPage, Integer pageSize) throws CommonServiceException;

    /**
     * 根据ID获取影片详情
     * @param filmId
     * @return
     * @throws CommonServiceException
     */
    FilmRespVO detailFilmById(String filmId) throws CommonServiceException;


    /**
     * 添加电影信息
     * @param filmSavedReqVO
     */
    void createFilm(FilmSavedReqVO filmSavedReqVO) throws CommonServiceException;

}
