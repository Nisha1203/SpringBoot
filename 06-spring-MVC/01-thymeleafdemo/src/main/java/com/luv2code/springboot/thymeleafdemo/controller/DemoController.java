package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    //create mapping
    @GetMapping("/hello")
    public String sayHello(Model themodel)
    {
        themodel.addAttribute("theData",java.time.LocalDate.now());

        return "helloworld";
    }
}
