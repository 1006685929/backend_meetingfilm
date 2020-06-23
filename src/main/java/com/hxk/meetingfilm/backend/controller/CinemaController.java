package com.hxk.meetingfilm.backend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Maps;
import com.hxk.meetingfilm.backend.common.vo.AllCinemaRespVO;
import com.hxk.meetingfilm.backend.common.vo.CinemaSaveReqVO;
import com.hxk.meetingfilm.backend.service.CinemaService;
import com.hxk.meetingfilm.backend.utils.common.vo.BasePageVO;
import com.hxk.meetingfilm.backend.utils.common.vo.BaseResponseVO;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author xiaokang.huang
 * @date 2020/6/9 16:23
 * @description 影院模块表现层
 */

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    /**
     * 分页获取影院列表
     * @param basePageVO
     * @return
     */
    @GetMapping
    public BaseResponseVO allCinemas(BasePageVO basePageVO) throws CommonServiceException {

        // 调用逻辑层，获取返回参数
        IPage<AllCinemaRespVO> results = cinemaService.allCinemas(basePageVO.getNowPage(),basePageVO.getPageSize());

        Map<String, Object> cinemas = pageResult(results, "cinemas");

        return BaseResponseVO.success(cinemas);
    }

    /**
     * 添加影院
     * @param reqVO
     * @return
     * @throws CommonServiceException
     */
    @PostMapping
    public BaseResponseVO saveCinema(@RequestBody CinemaSaveReqVO reqVO) throws CommonServiceException {
        reqVO.checkparam();

        cinemaService.createCinema(reqVO);
        return BaseResponseVO.success();
    }

    /**
     * 获取分页对象的公共接口
     * @param page
     * @param title
     * @return
     */
    private Map<String,Object> pageResult(IPage page, String title){
        Map<String,Object> result = Maps.newHashMap();

        result.put("totalSize",page.getTotal());
        result.put("totalPage",page.getPages());
        result.put("pageSize",page.getSize());
        result.put("nowPage",page.getCurrent());

        result.put(title,page.getRecords());
        return result;
    }
}
