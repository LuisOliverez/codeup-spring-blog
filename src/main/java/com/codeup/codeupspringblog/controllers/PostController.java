package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String getIndexPage(){
        return "Index page of posts";
    }


    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewPost(@PathVariable String id){
        return "View an individual post";
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreateForm(){
        return "Create new post form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        //logic for creating a new blog post
        return "Created a new post";
    }

}
