package com.hxk.meetingfilm.backend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Maps;
import com.hxk.meetingfilm.backend.common.vo.ActorsRespVO;
import com.hxk.meetingfilm.backend.common.vo.FilmRespVO;
import com.hxk.meetingfilm.backend.common.vo.FilmSavedReqVO;
import com.hxk.meetingfilm.backend.common.vo.FilmsRespVO;
import com.hxk.meetingfilm.backend.service.FilmService;
import com.hxk.meetingfilm.backend.utils.common.vo.BasePageVO;
import com.hxk.meetingfilm.backend.utils.common.vo.BaseResponseVO;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author xiaokang.huang
 * @date 2020/6/8 15:37
 * @description 影片模块展示层
 */

@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    /**
     * 获取演员列表
     * @param basePageVO
     * @return
     */
    @GetMapping("/actors")
    public BaseResponseVO selectAllActors(BasePageVO basePageVO) throws CommonServiceException {
        //入参检查
        basePageVO.checkparam();

        // 调用逻辑层，获取返回参数
        IPage<ActorsRespVO> results = filmService.allActors(basePageVO.getNowPage(),basePageVO.getPageSize());
        Map<String, Object> actors = pageResult(results, "actors");

        return BaseResponseVO.success(actors);
    }

    /**
     * 获取影片列表
     * @param basePageVO
     * @return
     */
    @GetMapping
    public BaseResponseVO selectAllFilms(BasePageVO basePageVO) throws CommonServiceException {
        //入参检查
        basePageVO.checkparam();

        // 调用逻辑层，获取返回参数
        IPage<FilmsRespVO> results = filmService.allFilms(basePageVO.getNowPage(),basePageVO.getPageSize());
        Map<String, Object> films = pageResult(results, "films");

        return BaseResponseVO.success(films);
    }

    /**
     * 根据ID获取影片详情
     * @param filmId
     * @return
     */
    @GetMapping("/{filmId}")
    public BaseResponseVO selectFilmById(@PathVariable("filmId")String filmId) throws CommonServiceException {
        FilmRespVO filmRespVO = filmService.detailFilmById(filmId);
        if (filmRespVO == null){
            return BaseResponseVO.success();
        }else {
            return BaseResponseVO.success(filmRespVO);
        }
    }

    /**
     * 添加影片信息
     * @param filmSavedReqVO
     * @return
     * @throws CommonServiceException
     */
    @PostMapping()
    public BaseResponseVO saveFilmInfo(@RequestBody FilmSavedReqVO filmSavedReqVO) throws CommonServiceException{

        filmService.createFilm(filmSavedReqVO);
        return BaseResponseVO.success();
    }

    /**
     * 获取分页对象的公共接口
     * @param page
     * @param title
     * @return
     */
    private Map<String,Object> pageResult(IPage page,String title){
        Map<String,Object> result = Maps.newHashMap();

        result.put("totalSize",page.getTotal());
        result.put("totalPage",page.getPages());
        result.put("pageSize",page.getSize());
        result.put("nowPage",page.getCurrent());

        result.put(title,page.getRecords());
        return result;
    }
}
