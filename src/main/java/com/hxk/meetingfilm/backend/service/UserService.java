package com.hxk.meetingfilm.backend.service;


import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;

/**
 * @author xiaokang.huang
 * @date 2020/6/5 15:50
 * @description 用户接口
 */

public interface UserService {

    /**
     * 用户登陆
     * @param username
     * @param password
     * @throws CommonServiceException
     */
    String checkUserLogin(String username, String password) throws CommonServiceException;
}
