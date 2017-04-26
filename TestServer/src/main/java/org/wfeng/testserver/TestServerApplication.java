package org.wfeng.testserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wfeng on 2017/4/24.
 */
@SpringBootApplication
public class TestServerApplication {

    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(TestServerApplication.class, args);
    }
}
