package com.yangtao.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Hello {
    @RequestMapping(value = {"/", "index"})
    public String hello() {
        return "index";
    }



}
