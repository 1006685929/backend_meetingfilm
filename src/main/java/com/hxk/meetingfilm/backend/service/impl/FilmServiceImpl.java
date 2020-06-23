package com.hxk.meetingfilm.backend.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hxk.meetingfilm.backend.common.vo.ActorsRespVO;
import com.hxk.meetingfilm.backend.common.vo.FilmRespVO;
import com.hxk.meetingfilm.backend.common.vo.FilmSavedReqVO;
import com.hxk.meetingfilm.backend.common.vo.FilmsRespVO;
import com.hxk.meetingfilm.backend.dao.entity.FilmFilmActorT;
import com.hxk.meetingfilm.backend.dao.entity.FilmFilmInfoT;
import com.hxk.meetingfilm.backend.dao.entity.FilmFilmT;
import com.hxk.meetingfilm.backend.dao.mapper.FilmActorTMapper;
import com.hxk.meetingfilm.backend.dao.mapper.FilmFilmActorTMapper;
import com.hxk.meetingfilm.backend.dao.mapper.FilmFilmInfoTMapper;
import com.hxk.meetingfilm.backend.dao.mapper.FilmFilmTMapper;
import com.hxk.meetingfilm.backend.service.FilmService;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import com.hxk.meetingfilm.backend.utils.util.ToolUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author xiaokang.huang
 * @date 2020/6/8 15:57
 * @description 影片模块实现层
 */

@Service
public class FilmServiceImpl implements FilmService {

    @Resource
    private FilmActorTMapper actorMapper;

    @Resource
    private FilmFilmActorTMapper filmActorMapper;

    @Resource
    private FilmFilmInfoTMapper filmInfoMapper;

    @Resource
    private FilmFilmTMapper filmMapper;


    @Override
    public IPage<ActorsRespVO> allActors(int nowPage, int pageSize) throws CommonServiceException {
        //查询演员列表
        return actorMapper.allActors(new Page<>(nowPage,pageSize));
    }

    @Override
    public IPage<FilmsRespVO> allFilms(Integer nowPage, Integer pageSize) throws CommonServiceException {
        //查询影片列表
        return filmMapper.allFilms(new Page<>(nowPage,pageSize));
    }

    @Override
    public FilmRespVO detailFilmById(String filmId) throws CommonServiceException {
        return filmMapper.selectFilmById(filmId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createFilm(FilmSavedReqVO reqVO) throws CommonServiceException {
        try {
            //保存电影主表
            FilmFilmT film = new FilmFilmT();
            film.setFilmName(reqVO.getFilmName());
            film.setFilmType(ToolUtils.str2Int(reqVO.getFilmTypeId()));
            film.setImgAddress(reqVO.getMainImgAddress());
            film.setFilmScore(reqVO.getFilmScore());
            film.setFilmPresalenum(ToolUtils.str2Int(reqVO.getPreSaleNum()));
            film.setFilmBoxOffice(ToolUtils.str2Int(reqVO.getBoxOffice()));
            film.setFilmSource(ToolUtils.str2Int(reqVO.getFilmSourceId()));
            film.setFilmCats(reqVO.getFilmCatIds());
            film.setFilmArea(ToolUtils.str2Int(reqVO.getAreaId()));
            film.setFilmDate(ToolUtils.str2Int(reqVO.getDateId()));
            film.setFilmTime(ToolUtils.str2LocalDateTime(reqVO.getFilmTime()+" 00:00:00"));
            film.setFilmStatus(ToolUtils.str2Int(reqVO.getFilmStatus()));
            filmMapper.insert(film);

            //保存电影信息表
            FilmFilmInfoT filmInfo = new FilmFilmInfoT();
            filmInfo.setFilmId(film.getUuid()+"");
            filmInfo.setFilmEnName(reqVO.getFilmEnName());
            filmInfo.setFilmScore(reqVO.getFilmScore());
            filmInfo.setFilmScoreNum(ToolUtils.str2Int(reqVO.getFilmScorers()));
            filmInfo.setFilmLength(ToolUtils.str2Int(reqVO.getFilmLength()));
            filmInfo.setBiography(reqVO.getBiography());
            filmInfo.setDirectorId(ToolUtils.str2Int(reqVO.getDirectorId()));
            filmInfo.setFilmImgs(reqVO.getFilmImgs());
            filmInfoMapper.insert(filmInfo);

            String[] actorId = reqVO.getActIds().split("#");
            String[] roleNames = reqVO.getRoleNames().split("#");
            if(actorId.length != roleNames.length){
                throw new CommonServiceException(500, "演员和角色名数量不匹配");
            }

            for(int i=0;i<actorId.length;i++) {
                // 保存演员映射表
                FilmFilmActorT filmActor = new FilmFilmActorT();

                filmActor.setFilmId(film.getUuid());
                filmActor.setActorId(ToolUtils.str2Int(actorId[i]));
                filmActor.setRoleName(roleNames[i]);
                filmActorMapper.insert(filmActor);
            }
        }catch (Exception e){
            throw new CommonServiceException(500,e.getMessage());
        }
    }
}
