package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2){
        int result = num1 + num2;
        return String.valueOf(result);
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2){
        int results = num1 - num2;
        return String.valueOf(results);
    }


    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2) {
        if (num2 != 0) {
            int results = num1 / num2;
            return String.valueOf(results);
        } else {
            return "Error: Can't divide by zero";
        }
    }



    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2){
        int results = num1 * num2;
        return String.valueOf(results);
    }



}
