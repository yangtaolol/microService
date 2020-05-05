package com.yangtao.springcloud.provider.user.controller;

import com.yangtao.springcloud.provider.user.dao.UserDao;
import com.yangtao.springcloud.provider.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/getHeader")
    public Map<String,String> getHeader(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        HashMap<String, String> map = new HashMap<>();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            map.put(key, request.getHeader(key));
        }
        return map;
    }

}
