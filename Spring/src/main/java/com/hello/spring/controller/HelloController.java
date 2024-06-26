package com.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        // key:data, value:hello!!
        model.addAttribute("data", "hello!!");
        return "hello";
    }
}
