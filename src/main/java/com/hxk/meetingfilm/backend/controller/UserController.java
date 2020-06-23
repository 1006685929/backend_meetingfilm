package com.hxk.meetingfilm.backend.controller;

/**
 * @author xiaokang.huang
 * @date 2020/6/22 9:29
 * @description
 */

import com.hxk.meetingfilm.backend.common.vo.LoginReqVO;
import com.hxk.meetingfilm.backend.service.UserService;
import com.hxk.meetingfilm.backend.utils.common.vo.BaseResponseVO;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import com.hxk.meetingfilm.backend.utils.util.JwtTokenUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaokang.huang
 * @date 2020/6/5 14:19
 * @description 用户模块表现层
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户登陆
     * @param reqVo
     * @return
     */
    @PostMapping("/login")
    public BaseResponseVO login(@RequestBody LoginReqVO reqVo) throws CommonServiceException {
        //数据检查验证
        reqVo.checkparam();

        //检出用户名密码是否正确
        String userId = userService.checkUserLogin(reqVo.getUsername(), reqVo.getPassword());

        //获取randomKey和token
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String randomKey = jwtTokenUtil.getRandomKey();
        String token = jwtTokenUtil.generateToken(userId, randomKey);

        // 返回randomKey token
        Map<String, String> result = new HashMap<>();
        result.put("randomKey", randomKey);
        result.put("token", token);

        return BaseResponseVO.success(result);
    }
}