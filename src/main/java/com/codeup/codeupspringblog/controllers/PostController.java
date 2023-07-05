package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String getIndexPage(Model model){
        List<Post> posts = new ArrayList<>();

        posts.add((new Post("First Post", "This is the first post.")));
        posts.add((new Post("Second Post", "Second post.")));
        posts.add((new Post("Third Test", "Third test")));
        model.addAttribute("posts", posts);

        return "posts/index";

    }


    //SHOULD THIS TAKE AN INT FOR THE ID??
    @GetMapping("/posts/{id}")//set url string with variable id
    public String viewPost(@PathVariable Long id, Model model){//include pathvariable

        Post post = new Post("Sample Post", "This is a sample post.");

        model.addAttribute("post", post);

        return "posts/show";
    }


    @GetMapping("/posts/create")//set url string
    public String getCreateForm(){
        return "posts/create";
    }

    @PostMapping("/posts/create")//set url string
    public String createPost(){
        //logic for creating a new blog post
        return "redirect:/posts";
    }


}
