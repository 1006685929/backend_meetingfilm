package com.hxk.meetingfilm.backend.common.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaokang.huang
 * @date 2020/7/15 12:30
 * @description
 */

@Configuration
public class MinIoConfig {

    @Value("${min.io.endpoint}")
    public String endpoint;

    @Value("${min.io.accessKey}")
    public String accessKey;

    @Value("${min.io.secretKey}")
    public String secretKey;

    @Value("${min.io.bucket-name}")
    public String bucketName;

    @Bean
    public MinioClient getMinIoClient(){
        MinioClient minioClient = MinioClient.builder().endpoint(endpoint).credentials(accessKey,secretKey).build();
        return minioClient;
    }
}
