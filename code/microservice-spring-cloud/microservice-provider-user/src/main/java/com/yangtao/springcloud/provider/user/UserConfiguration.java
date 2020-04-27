package com.yangtao.springcloud.provider.user;

import com.yangtao.springcloud.provider.user.dao.UserDao;
import com.yangtao.springcloud.provider.user.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class UserConfiguration {

    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        User user1 = new User(1L, "admin1", "yt1", 25, new BigDecimal(1000));
        User user2 = new User(2L, "admin2", "yt2", 25, new BigDecimal(1000));
        User user3 = new User(3L, "admin3", "yt3", 25, new BigDecimal(1000));
        userDao.addUser(user1, user2, user3);
        return userDao;
    }
}
