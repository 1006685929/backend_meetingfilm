package com.hxk.meetingfilm.backend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Maps;
import com.hxk.meetingfilm.backend.common.vo.HallSavedReqVO;
import com.hxk.meetingfilm.backend.common.vo.HallsReqVO;
import com.hxk.meetingfilm.backend.common.vo.HallsRespVO;
import com.hxk.meetingfilm.backend.service.HallService;
import com.hxk.meetingfilm.backend.utils.common.vo.BaseResponseVO;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author xiaokang.huang
 * @date 2020/6/10 11:19
 * @description
 */

@RequestMapping("/halls")
@RestController
public class HallController {

    @Autowired
    private HallService hallService;


    /**
     * 查询影厅列表
     * @param hallsReqVO
     * @return
     * @throws CommonServiceException
     */
    @GetMapping
    public BaseResponseVO allHalls(HallsReqVO hallsReqVO) throws CommonServiceException {
        hallsReqVO.checkparam();

        //获取返回分页对象
        IPage<HallsRespVO> page = hallService.selectAllHalls(hallsReqVO);
        Map<String, Object> halls = pageResult(page, "halls");

        return BaseResponseVO.success(halls);
    }

    /**
     * 新增影厅
     * @return
     * @throws CommonServiceException
     */
    @PostMapping
    public BaseResponseVO saveHall(@RequestBody HallSavedReqVO hallSavedReqVO) throws CommonServiceException{
        hallSavedReqVO.checkparam();

        hallService.createHall(hallSavedReqVO);

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
