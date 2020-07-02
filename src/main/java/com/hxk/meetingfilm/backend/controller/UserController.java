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
import org.springframework.web.bind.annotation.*;

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

    /**
     * 退出登陆
     * @return
     */
    @PostMapping("/logout")
    public BaseResponseVO logout(){
        /*
            应用：
                1、前端存储JWT 【七天】 ： JWT的刷新
                2、服务器端会存储活动用户信息【30分钟】
                3、JWT里的userId为key，查找活跃用户
            退出：
                1、前端删除掉JWT
                2、后端服务器删除活跃用户缓存
            现状：
                1、前端删除掉JWT
         */
        return BaseResponseVO.success("用户退出成功");
    }
}