package com.hxk.meetingfilm.backend.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxk.meetingfilm.backend.common.vo.ActorsRespVO;
import com.hxk.meetingfilm.backend.dao.entity.FilmActorT;

/**
 * <p>
 * 演员表 Mapper 接口
 * </p>
 *
 * @author hxk
 * @since 2020-06-08
 */
public interface FilmActorTMapper extends BaseMapper<FilmActorT> {

    /**
     * 演员列表查询
     * @param page
     * @return
     */
    IPage<ActorsRespVO> allActors(Page<ActorsRespVO> page);

}
