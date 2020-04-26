package com.yangtao.springcloud.consumer.movie.client;

import com.yangtao.springcloud.consumer.movie.model.User;
import org.springframework.stereotype.Component;


@Component(value = "userFallback")
public class UserFallback implements UserClient {

    @Override
    public User getUser(Long id) {
        return new User();
    }

    @Override
    public boolean isExist(User user) {
        return false;
    }
}
