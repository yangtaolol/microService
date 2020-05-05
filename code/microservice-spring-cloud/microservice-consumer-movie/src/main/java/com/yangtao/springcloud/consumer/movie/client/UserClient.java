package com.yangtao.springcloud.consumer.movie.client;

import com.yangtao.springcloud.consumer.movie.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "microservice-provider-user", fallback = UserFallback.class,path = "/user")
public interface UserClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable Long id);

    @PostMapping(value = "/isExist", consumes = "application/json")
    boolean isExist(User user);
}
