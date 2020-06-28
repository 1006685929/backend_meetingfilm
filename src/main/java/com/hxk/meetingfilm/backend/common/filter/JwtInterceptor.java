package com.hxk.meetingfilm.backend.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.hxk.meetingfilm.backend.utils.common.vo.BaseResponseVO;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import com.hxk.meetingfilm.backend.utils.properties.JwtProperties;
import com.hxk.meetingfilm.backend.utils.util.JwtTokenUtil;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiaokang.huang
 * @date 2020/6/28 10:46
 * @description
 */

@Slf4j
public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // JWT工具类
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        // jwt配置类
        JwtProperties jwtProperties = JwtProperties.getJwtProperties();

        // 判断是否是登陆，如果是登陆则不验证JWT,不拦截
        if (request.getServletPath().endsWith("/" + jwtProperties.getAuthPath())) {
            return true;
        }

        //1、验证Token有效性 -> 用户是否登录过
        final String requestHeader = request.getHeader(jwtProperties.getHeader());
        String authToken = null;
        // Bearer header.payload.signature
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);
            try {
                boolean flag = jwtTokenUtil.isTokenExpired(authToken);
                if (flag) {
                    renderJson(response, BaseResponseVO.noLogin());
                    return false;
                } else {
                    // 2、解析出JWT中的payload -> userid - randomkey
                    String randomkey = jwtTokenUtil.getMd5KeyFromToken(authToken);
                    String userId = jwtTokenUtil.getUsernameFromToken(authToken);
                    // 3、是否需要验签,以及验签的算法

                    // 4、判断userid是否有效
                    // TODO
                }
            } catch (JwtException e) {
                //有异常就是token解析失败
                renderJson(response, BaseResponseVO.noLogin());
                return false;
            }
        }else {
            //header没有带Bearer字段
            renderJson(response, BaseResponseVO.noLogin());
            return false;
        }
        return true;
    }

    private static void renderJson(HttpServletResponse response, BaseResponseVO jsonObject) throws IOException {
        // 设置终止请求
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.getWriter().append(JSONObject.toJSONString(jsonObject));
    }
}


