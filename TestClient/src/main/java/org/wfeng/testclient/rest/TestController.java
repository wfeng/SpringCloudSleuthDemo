package org.wfeng.testclient.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.wfeng.testclient.rest.vo.Account;
import org.wfeng.testclient.rest.vo.User;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wfeng on 2017/4/24.
 */
@RestController
public class TestController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hi")
    public String hi(){
        return restTemplate.getForEntity("http://localhost:8081/say_hello",String.class).getBody();
    }

    @RequestMapping("/")
    public Object account(String userId){
        if (StringUtils.isEmpty(userId)) {
            userId = "1";
        }
        log.debug("userId {}", userId);
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("userId", userId);
        String json = restTemplate.postForObject("http://localhost:8081/get_user_info", request, String.class);
        return json;
    }
}
