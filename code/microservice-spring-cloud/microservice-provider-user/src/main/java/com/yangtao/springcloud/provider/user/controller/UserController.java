package com.yangtao.springcloud.provider.user.controller;

import com.yangtao.springcloud.provider.user.dao.UserDao;
import com.yangtao.springcloud.provider.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userDao.findById(id);
    }

    @PostMapping("/isExist")
    public boolean isExist(@RequestBody User user){
        List<User> list = userDao.findAll();
        for (User existUser : list) {
            if (existUser.getName().equals(user.getName())) {
                return true;
            }
        }
        return false;
    }

}
