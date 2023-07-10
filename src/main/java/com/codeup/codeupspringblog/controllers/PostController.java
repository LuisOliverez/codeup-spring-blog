package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController {

    private final PostRepository postRepository;
    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @GetMapping("/posts")
    public String index(Model model){
//        List<Post> posts = new ArrayList<>();
//
//        posts.add((new Post( 1L ,"First Post", "This is the first post.")));
//        posts.add((new Post(2L,"Second Post", "Second post.")));
//        posts.add((new Post(3L,"Third Test", "Third test")));

//        model.addAttribute("posts", postDao.findAll());

        return "posts/index";

    }


    //SHOULD THIS TAKE AN INT FOR THE ID??
    @GetMapping("/posts/{id}")//set url string with variable id
    public String viewPost(@PathVariable Long id, Model model){//include pathvariable

        Post post = new Post(1L,"Sample Post", "This is a sample post.");

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
