package com.hxk.meetingfilm.backend.common.vo;

import lombok.Data;

/**
 * @author xiaokang.huang
 * @date 2020/6/8 15:42
 * @description 获取演员列表VO对象
 */

@Data
public class ActorsRespVO {

    /**
     * 演员id
     */
    private Integer actorId;
    /**
     * 演员姓名
     */
    private String actorName;
}
