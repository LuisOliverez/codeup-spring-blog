package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Optional;
import java.util.Random;


@Controller
public class PostController {


    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }


    @GetMapping("/posts")
    public String index(Model model){

        model.addAttribute("posts", postRepository.findAll());

        return "posts/index";

    }



    //SHOULD THIS TAKE AN INT FOR THE ID??
    @GetMapping("/posts/{id}")//set url string with variable id
    public String viewPost(@PathVariable Long id, Model model) {//include pathvariable

        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();


            model.addAttribute("post", post);

            return "posts/show";
        } else {
            return "error";
        }
    }

    @GetMapping("/posts/create")//set url string
    public String getCreateForm(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam String title, @RequestParam String body, @RequestParam Long user_id) {
        // Create a new post object
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);

        // Get the user from the UserRepository using user_id
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            post.setUser(user);
        } else {
            return "error";
        }

        postRepository.save(post);

        return "redirect:/posts";
    }



}
