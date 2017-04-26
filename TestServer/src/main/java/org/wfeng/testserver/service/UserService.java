package org.wfeng.testserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.wfeng.testserver.rest.vo.User;

import java.util.concurrent.Future;

/**
 * Created by wfeng on 2017/4/25.
 */
@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Async
    public Future<User> getUser(String userId){
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("userId", userId);
        User user = restTemplate.postForObject("http://localhost:8082/get_user", request, User.class);
        return new AsyncResult<>(user);
    }
}
