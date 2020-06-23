package com.hxk.meetingfilm.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxk.meetingfilm.backend.common.vo.FilmRespVO;
import com.hxk.meetingfilm.backend.common.vo.HallSavedReqVO;
import com.hxk.meetingfilm.backend.common.vo.HallsReqVO;
import com.hxk.meetingfilm.backend.common.vo.HallsRespVO;
import com.hxk.meetingfilm.backend.dao.entity.FilmFieldT;
import com.hxk.meetingfilm.backend.dao.entity.FilmHallFilmInfoT;
import com.hxk.meetingfilm.backend.dao.mapper.FilmFieldTMapper;
import com.hxk.meetingfilm.backend.dao.mapper.FilmFilmTMapper;
import com.hxk.meetingfilm.backend.dao.mapper.FilmHallFilmInfoTMapper;
import com.hxk.meetingfilm.backend.service.HallService;
import com.hxk.meetingfilm.backend.utils.common.vo.BaseResponseVO;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import com.hxk.meetingfilm.backend.utils.util.ToolUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author xiaokang.huang
 * @date 2020/6/10 11:18
 * @description
 */

@Service
public class HallServiceImpl implements HallService {

    @Resource
    private FilmFieldTMapper fieldTMapper;

    @Resource
    private FilmHallFilmInfoTMapper hallFilmInfoTMapper;

    @Resource
    private FilmFilmTMapper filmTMapper;


    @Override
    public IPage<HallsRespVO> selectAllHalls(HallsReqVO hallsReqVO) throws CommonServiceException {

        Page<HallsReqVO> page = new Page<>(hallsReqVO.getNowPage(),hallsReqVO.getPageSize());

        //条件查询
        QueryWrapper queryWrapper = new QueryWrapper();
        if (ToolUtils.strIsNotNull(hallsReqVO.getCinemaId())){
            queryWrapper.eq("cinema_id",hallsReqVO.getCinemaId());
        }

        IPage<HallsRespVO> halls = fieldTMapper.selectAllHalls(page, queryWrapper);
        return halls;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createHall(HallSavedReqVO reqVO) throws CommonServiceException {
        // 播放厅的列表数据
        FilmFieldT field = new FilmFieldT();

        field.setCinemaId(ToolUtils.str2Int(reqVO.getCinemaId()));
        field.setFilmId(ToolUtils.str2Int(reqVO.getFilmId()));
        field.setBeginTime(reqVO.getBeginTime());
        field.setEndTime(reqVO.getEndTime());
        field.setHallId(ToolUtils.str2Int(reqVO.getHallTypeId()));
        field.setHallName(reqVO.getHallName());
        field.setPrice(ToolUtils.str2Int(reqVO.getFilmPrice()));

        fieldTMapper.insert(field);

        // 播放厅对应的影片数据， 影片冗余数据， 缓存里应该有一份
        FilmHallFilmInfoT hallFilmInfo = describeFilmInfo(reqVO.getFilmId());

        hallFilmInfoTMapper.insert(hallFilmInfo);
    }

    //插入数据到hallFilmInfo
    private FilmHallFilmInfoT describeFilmInfo(String filmId) throws CommonServiceException {

        //解析返回值
        FilmRespVO filmResult = filmTMapper.selectFilmById(filmId);
        if (filmResult == null || ToolUtils.strIsNull(filmResult.getFilmId())){
            throw new CommonServiceException(404,"抱歉，未找到相应的影片信息，filmId："+filmId);
        }

        // 组织参数
        // TODO 这里会报空指针，主要是filmId不存在
        FilmHallFilmInfoT hallFilmInfo = new FilmHallFilmInfoT();

        hallFilmInfo.setFilmId(ToolUtils.str2Int(filmResult.getFilmId()));
        hallFilmInfo.setFilmName(filmResult.getFilmName());
        hallFilmInfo.setFilmLength(filmResult.getFilmLength());
        hallFilmInfo.setFilmCats(filmResult.getFilmCats());
        hallFilmInfo.setActors(filmResult.getActors());
        hallFilmInfo.setImgAddress(filmResult.getImgAddress());

        return hallFilmInfo;
    }
}
