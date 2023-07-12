package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.EmailService;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;


@Controller
public class PostController {


    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;

    @Autowired
    public PostController(PostRepository postRepository, UserRepository userRepository, EmailService emailService) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.emailService = emailService;
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
    public String getCreateForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }


    //maps to form to create a new post
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post, @RequestParam Long id) {
        // Create a new post object
//        Post post = new Post();
//        post.setTitle(title);
//        post.setBody(body);

        // Get the user from the UserRepository using user_id
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            post.setUser(user);
        } else {
            return "error";
        }

//        //sends confirmation email to test email(for now)
//        String subject = "New Post Created";
//        String emailBody = "A new post has been created: " + post.getTitle();
//        emailService.prepareAndSend(post, subject, emailBody);

        //saves the post to the database via postRepository
        postRepository.save(post);

        //redirects to posts page with new post listed
        return "redirect:/posts";
    }


    //mapping to edit post form
    @GetMapping("/posts/{id}/edit")
    public  String editPost(@PathVariable Long id, Model model){
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "posts/edit";
        }else {
            return "error";
        }
    }


    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable Long id, @ModelAttribute("post") Post updatePost){
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            //update the post with the new data
            post.setTitle(updatePost.getTitle());
            post.setBody(updatePost.getBody());
            //save the updated post
            postRepository.save(post);
            return "redirect:/posts/{id}";
        }else {
            return "error";
        }
    }




}
