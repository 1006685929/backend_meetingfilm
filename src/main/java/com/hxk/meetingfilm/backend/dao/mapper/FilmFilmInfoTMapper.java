package com.hxk.meetingfilm.backend.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxk.meetingfilm.backend.common.vo.FilmSavedReqVO;
import com.hxk.meetingfilm.backend.dao.entity.FilmFilmInfoT;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author hxk
 * @since 2020-06-08
 */
public interface FilmFilmInfoTMapper extends BaseMapper<FilmFilmInfoT> {

    FilmSavedReqVO createFilm();

}
