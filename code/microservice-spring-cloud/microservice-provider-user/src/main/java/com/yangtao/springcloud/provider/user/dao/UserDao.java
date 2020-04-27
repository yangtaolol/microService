package com.yangtao.springcloud.provider.user.dao;

import com.yangtao.springcloud.provider.user.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDao{

    List<User> users = new ArrayList<>();

    public void addUser(User... users) {
        if (users == null || users.length == 0) {
            return;
        }
        this.users.addAll(Arrays.asList(users));
    }


    public User findById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> findAll() {
        return users;
    }
}
