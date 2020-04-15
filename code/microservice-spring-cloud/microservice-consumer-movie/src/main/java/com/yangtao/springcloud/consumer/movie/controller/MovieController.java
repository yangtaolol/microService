package com.yangtao.springcloud.consumer.movie.controller;


import com.yangtao.springcloud.consumer.movie.client.EurekaClient;
import com.yangtao.springcloud.consumer.movie.client.UserClient;
import com.yangtao.springcloud.consumer.movie.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userClient.getUser(id);
    }

    @GetMapping("isExist")
    public boolean isExist(){
        User user = new User();
        user.setName("杨韜1");
        return userClient.isExist(user);
    }

    @RequestMapping("/getAppInfo/{appName}")
    public String getAppInfo(@PathVariable String appName) {
        return eurekaClient.getUserInfo("microservice-provider-" + appName);
    }
}
