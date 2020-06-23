package com.hxk.meetingfilm.backend.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxk.meetingfilm.backend.common.vo.HallsReqVO;
import com.hxk.meetingfilm.backend.common.vo.HallsRespVO;
import com.hxk.meetingfilm.backend.dao.entity.FilmFieldT;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author hxk
 * @since 2020-06-10
 */
public interface FilmFieldTMapper extends BaseMapper<FilmFieldT> {

    /**
     * 查询影厅列表
     * @param page
     * @param queryWrapper
     * @return
     */
    IPage<HallsRespVO> selectAllHalls(Page<HallsReqVO> page, @Param("ew") QueryWrapper queryWrapper);

}
