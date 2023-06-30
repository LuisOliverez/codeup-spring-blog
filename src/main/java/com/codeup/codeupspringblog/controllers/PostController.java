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


    //SHOULD THIS TAKE AN INT FOR THE ID??
    @GetMapping("/posts/{id}")//set url string with variable id
    @ResponseBody
    public String viewPost(@PathVariable Long id){//include pathvariable
        return "View an individual post" + id;
    }


    @GetMapping("/posts/create")//set url string
    @ResponseBody
    public String getCreateForm(){
        return "Create new post form";
    }

    @PostMapping("/posts/create")//set url string
    @ResponseBody
    public String createPost(){
        //logic for creating a new blog post
        return "Created a new post";
    }

}
