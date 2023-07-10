package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



import java.util.Optional;


@Controller
public class PostController {


    private final PostRepository postRepository;
    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
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
        Post post  = new Post();
        post.setTitle(title);
        post.setBody(body);

        postRepository.save(post);

        return "redirect:/posts";
    }


}
