package com.hxk.meetingfilm.backend.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxk.meetingfilm.backend.common.vo.FilmRespVO;
import com.hxk.meetingfilm.backend.common.vo.FilmsRespVO;
import com.hxk.meetingfilm.backend.dao.entity.FilmFilmT;
import com.hxk.meetingfilm.backend.utils.common.vo.BaseResponseVO;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author hxk
 * @since 2020-06-08
 */
public interface FilmFilmTMapper extends BaseMapper<FilmFilmT> {

    /**
     * 影片列表查询
     * @param page
     * @return
     */
    IPage<FilmsRespVO> allFilms(Page<FilmsRespVO> page);

    /**
     * 根据filmId查询影片
     * @param filmId
     * @return
     */
    FilmRespVO selectFilmById(@Param("filmId") String filmId);


}
