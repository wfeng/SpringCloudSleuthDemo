package org.wfeng.billserver.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wfeng.billserver.rest.vo.Account;

import java.math.BigDecimal;

/**
 * Created by wfeng on 2017/4/24.
 */
@Api("账户服务端api")
@RestController
public class AccountController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ApiOperation("获取名字")
    @RequestMapping("/get_user_account")
    public Object getUserAccount(String userId){

        if (!StringUtils.isEmpty(userId)) {
            log.debug("userId {}", userId);
            if (userId.equalsIgnoreCase("1")) {
                return new Account(new BigDecimal(100.00));
            } else {
                return new Account(new BigDecimal(0));
            }
        }
        return null;
    }
}
