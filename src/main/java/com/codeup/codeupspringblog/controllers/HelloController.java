package com.codeup.codeupspringblog.controllers;

import jakarta.annotation.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller//tells computer this is a controller
public class HelloController {
    /*
    "/hello" will display Hello, World
    "/hello?name=bob" will display Hello, Bob!
    "/hello/bob" will display Hello, Bob!
     */

//    @GetMapping("/hello")                                     set url string to "/hello"
//    @ResponseBody                                               whatever is returned will be the body
//    public String sayHello(@RequestParam @Nullable String name){
//        if (name == null){
//            name = "world";
//        }
//        return "<h1>Hello, " + name + "!</h1>";
//    }
//
//
//    @GetMapping("/hello/{personName}")                                     //set url string to "/hello"
//    @ResponseBody                                               //whatever is returned will be the body
//    public String sayHelloToName(@PathVariable String personName){
//        if (personName == null){
//            personName = "world";
//        }
//        return "<h1>Hello, " + personName + "!</h1>";
//    }
@GetMapping("/hello/{name}")
public String sayHello(@PathVariable String name, Model model) {
    model.addAttribute("name", name);
    return "hello";
}


}


