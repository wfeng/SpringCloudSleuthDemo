package org.wfeng.testserver.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.wfeng.testserver.rest.vo.Account;
import org.wfeng.testserver.rest.vo.User;
import org.wfeng.testserver.service.AccountService;
import org.wfeng.testserver.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * Created by wfeng on 2017/4/24.
 */
@Api("测试服务端api")
@RestController
public class TestController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    @Autowired
    private RestTemplate restTemplate;


    @ApiOperation("说你好")
    @RequestMapping("/say_hello")
    public String sayHello(){
        String name = restTemplate.getForEntity("http://localhost:8082/get_name",String.class).getBody();
        return name + " Hello!";
    }

    @ApiOperation("获取用户信息")
    @RequestMapping("/get_user_info")
    public Object getUserInfo(String userId){

        log.debug("userId {}", userId);

        Future<User> user =  userService.getUser(userId);
        Future<Account> account =  accountService.getAccount(userId);

        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("code", "0000");
        ret.put("msg", "succee");

        try {
            while (true) {
                if (user.isDone() && account.isDone()) {
                    ret.put("user", user.get());
                    ret.put("account", account.get());
                    break;
                }
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return ret;
    }
}
