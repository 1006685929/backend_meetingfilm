package com.hxk.meetingfilm.backend.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxk.meetingfilm.backend.common.vo.AllCinemaRespVO;
import com.hxk.meetingfilm.backend.common.vo.CinemaSaveReqVO;
import com.hxk.meetingfilm.backend.dao.entity.FilmCinemaT;
import com.hxk.meetingfilm.backend.dao.mapper.FilmCinemaTMapper;
import com.hxk.meetingfilm.backend.service.CinemaService;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import com.hxk.meetingfilm.backend.utils.util.ToolUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaokang.huang
 * @date 2020/6/9 16:38
 * @description 实现层
 */

@Service
public class CinemaServiceImpl implements CinemaService {

    @Resource
    private FilmCinemaTMapper cinemaTMapper;

    @Override
    public void createCinema(CinemaSaveReqVO cinemaSaveReqVO) throws CommonServiceException {

        FilmCinemaT cinemaT = new FilmCinemaT();
        cinemaT.setCinemaName(cinemaSaveReqVO.getCinemaName());
        cinemaT.setCinemaPhone(cinemaSaveReqVO.getCinemaTele());
        cinemaT.setBrandId(cinemaSaveReqVO.getBrandId());
        cinemaT.setAreaId(cinemaSaveReqVO.getAreaId());
        cinemaT.setHallIds(cinemaSaveReqVO.getHallTypeIds());
        cinemaT.setImgAddress(cinemaSaveReqVO.getCinemaImgAddress());
        cinemaT.setCinemaAddress(cinemaSaveReqVO.getCinemaAddress());
        cinemaT.setMinimumPrice(ToolUtils.str2Int(cinemaSaveReqVO.getCinemaPrice()));

        cinemaTMapper.insert(cinemaT);
        return;
    }

    @Override
    public IPage<AllCinemaRespVO> allCinemas(int nowPage, int pageSize) throws CommonServiceException {

        // 查询实体对象，然后与表现层对象进行交互
        Page<FilmCinemaT> page = new Page<>(nowPage,pageSize);
        //无条件查找，返回IPage<FilmCinemaT>
        IPage<FilmCinemaT> cinemaTIPage = cinemaTMapper.selectPage(page, null);

        //用List来承载cinemaTIPage中的records（循环）
        List<AllCinemaRespVO> describeCinemaRespVOS = cinemaTIPage.getRecords().stream()
                .map(CinemaServiceImpl::transform).collect(Collectors.toList());

        IPage<AllCinemaRespVO> respVOIPage = new Page<>();

        //进行对象之间的属性赋值
        BeanUtils.copyProperties(cinemaTIPage, respVOIPage);
        respVOIPage.setRecords(describeCinemaRespVOS);
        return respVOIPage;
    }

    @Override
    public FilmCinemaT selectCinemaById(String cinemaId) throws CommonServiceException {
        return cinemaTMapper.selectById(cinemaId);
    }

    @Override
    public void updateCinema(FilmCinemaT cinemaT) throws CommonServiceException {
        cinemaTMapper.updateById(cinemaT);
    }

    @Override
    public void deleteCinema(String cinemaId) {
        cinemaTMapper.deleteById(cinemaId);
    }

    /**
     * 对象组装
     * @param cinema
     * @return
     */
    private static AllCinemaRespVO transform(FilmCinemaT cinema) {
        AllCinemaRespVO cinemaRespVO = new AllCinemaRespVO();
        cinemaRespVO.setBrandId(cinema.getBrandId().toString());
        cinemaRespVO.setAreaId(cinema.getAreaId().toString());
        cinemaRespVO.setHallTypeIds(cinema.getHallIds());
        cinemaRespVO.setCinemaName(cinema.getCinemaName());
        cinemaRespVO.setCinemaAddress(cinema.getCinemaAddress());
        cinemaRespVO.setCinemaTele(cinema.getCinemaPhone());
        cinemaRespVO.setCinemaImgAddress(cinema.getImgAddress());
        cinemaRespVO.setCinemaPrice(cinema.getMinimumPrice().toString());

        return cinemaRespVO;
    }
}
