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

    @PostMapping("/posts/create")//set url string
    public String createPost(@RequestParam String title, @RequestParam String body){
       //CREATE NEW POST OBJECT
        Post post  = new Post();
        post.setTitle(title);
        post.setBody(body);

        //GET A RANDOM USER FROM THE USERREPOSITORY
        List<User> users = userRepository.findAll();
        if (!users.isEmpty()){
            User randomUser = users.get(new Random().nextInt(users.size()));
        post.setUser(randomUser);
        }else {
            return "error";
        }





        postRepository.save(post);

        return "redirect:/posts";
    }


}
