package com.hxk.meetingfilm.backend.utils.util;


import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author xiaokang.huang
 * @date 2020/7/2 11:15
 * @description minIo工具类
 */

public class MinIoUtils {


    public String upload()throws NoSuchAlgorithmException, IOException, InvalidKeyException {

        try {
            MinioClient minioClient = MinioClient.builder().endpoint("http://47.95.2.90:9000").credentials("admin","123123123").build();
            // Check if the bucket already exists.
            boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket("test").build());
            if (isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // Make a new bucket called asiatrip to hold a zip file of photos.
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("test").build());
            }

            // Upload the file to the bucket with putObject
            minioClient.uploadObject(UploadObjectArgs.builder().bucket("test").object("bbb.jpg").filename("C:\\Users\\HXK\\Pictures\\Saved Pictures\\bbb.jpg").build());
            System.out.println("C:\\Users\\HXK\\Pictures\\Saved Pictures\\bbb.jpg is successfully uploaded as bbb.jpg to `test` bucket.");
            String url = minioClient.getObjectUrl("test", "bbb.jpg");
            System.out.println(url);
            return url;
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
            return "上传成功";
        }
    }

}