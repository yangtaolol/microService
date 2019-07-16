package com.yangtao.demo.controller;

import com.yangtao.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Hello {

    @Autowired
    private User user;

    @RequestMapping(value = {"/", "index"})
    public String hello(Model model) {
        model.addAttribute("user", user);
        return "index";
    }



}
