package com.yangtao.springcloud.microservicegateway.controller;

import com.yangtao.springcloud.microservicegateway.config.GlobalAuthFilter;
import com.yangtao.springcloud.microservicegateway.entity.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TokenController {

    @Autowired
    private Environment environment;

    @RequestMapping("/getToken")
    public String getToken(String appName) {
        if (StringUtils.isEmpty(appName)) {
            return "invalid args";
        }
        String expireDate = environment.getProperty("auth.expireDate");
        String tokenValue = UUID.randomUUID().toString().replace("-", "");
        Integer expireValue = expireDate == null ? null : Integer.parseInt(expireDate);
        Token token = new Token(tokenValue, expireValue);
        GlobalAuthFilter.map.put(appName.toLowerCase(), token);
        return tokenValue;
    }
}
