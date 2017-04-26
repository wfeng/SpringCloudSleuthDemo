package org.wfeng.testserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.wfeng.testserver.rest.vo.Account;
import org.wfeng.testserver.rest.vo.User;

import java.util.concurrent.Future;

/**
 * Created by wfeng on 2017/4/25.
 */
@Service
public class AccountService {

    @Autowired
    private RestTemplate restTemplate;

    @Async
    public Future<Account> getAccount(String userId){
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("userId", userId);
        Account account = restTemplate.postForObject("http://localhost:8083/get_user_account", request, Account.class);
        return new AsyncResult<>(account);
    }
}
