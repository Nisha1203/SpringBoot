package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    //new a controller method to show initial HTML form

    @RequestMapping("/showform")
    public String showForm(){
        return "helloworld-form";
    }

    //need a controller to process the form
    @RequestMapping("/processForm")
    public  String processForm()
    {
        return "HelloWorld";
    }
}
