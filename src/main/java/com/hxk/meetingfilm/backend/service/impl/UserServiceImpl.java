package com.hxk.meetingfilm.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxk.meetingfilm.backend.dao.entity.FilmBackendUserT;
import com.hxk.meetingfilm.backend.dao.mapper.FilmBackendUserTMapper;
import com.hxk.meetingfilm.backend.service.UserService;
import com.hxk.meetingfilm.backend.utils.exception.CommonServiceException;
import com.hxk.meetingfilm.backend.utils.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaokang.huang
 * @date 2020/6/5 15:53
 * @description 用户模块业务实现
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private FilmBackendUserTMapper userMapper;

    @Override
    public String checkUserLogin(String username, String password) throws CommonServiceException {

        //根据用户名获取用户信息
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_name",username);

        // 避免数据出现问题
        List<FilmBackendUserT> list = userMapper.selectList(wrapper);
        FilmBackendUserT user = null;
        if (list != null && list.size()>0){
            user = list.stream().findFirst().get();
        }else {
            throw new CommonServiceException(404,"用户名输入错误");
        }

        //验证密码是否正确，要做md5加密后验证
        String encrypt = MD5Util.encrypt(password);
        if (!encrypt.equals(user.getUserPwd())){
            throw new CommonServiceException(500,"密码错误");
        }else {
            return user.getUuid()+"";
        }

    }
}
