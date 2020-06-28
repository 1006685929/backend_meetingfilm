package com.hxk.meetingfilm.backend.common.config;

import com.hxk.meetingfilm.backend.common.filter.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiaokang.huang
 * @date 2020/6/28 10:41
 * @description 拦截配置
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor()).addPathPatterns("/**");
    }
}
