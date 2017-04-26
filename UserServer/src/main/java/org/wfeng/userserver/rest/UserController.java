package org.wfeng.userserver.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wfeng.userserver.rest.vo.User;

/**
 * Created by wfeng on 2017/4/24.
 */
@Api("用户服务端api")
@RestController
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ApiOperation("获取名字")
    @RequestMapping("/get_name")
    public String getName(){
        return "wfeng";
    }

    @ApiOperation("获取用户")
    @RequestMapping("/get_user")
    public Object getUser(String userId){
        log.debug("userId {}", userId);

        if (!StringUtils.isEmpty(userId)) {
            return new User(userId, "wfeng");
        }
        return new User("2", "coffee");
    }
}
