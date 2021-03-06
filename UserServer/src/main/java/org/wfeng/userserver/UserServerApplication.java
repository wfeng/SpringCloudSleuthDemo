package org.wfeng.userserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

/**
 * Created by wfeng on 2017/4/24.
 */
@SpringBootApplication
public class UserServerApplication {

    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }
}
