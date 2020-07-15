package com.hxk.meetingfilm.backend.controller;

import com.hxk.meetingfilm.backend.utils.util.MinIoUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author xiaokang.huang
 * @date 2020/7/13 12:23
 * @description 文件控制表现层
 */

@RestController
@RequestMapping()
public class FileController {

    MinIoUtils minIoUtils = new MinIoUtils();

    @PostMapping("/uploadImg")
    public String uploadImg() throws NoSuchAlgorithmException, InvalidKeyException, IOException {
        minIoUtils.upload();
        return "上传成功";
    }
}
