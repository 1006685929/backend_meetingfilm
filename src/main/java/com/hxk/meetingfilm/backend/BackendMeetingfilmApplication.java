package com.hxk.meetingfilm.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class BackendMeetingfilmApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendMeetingfilmApplication.class, args);
    }

}
