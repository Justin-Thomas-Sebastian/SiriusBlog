package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable long id, Model model){
        model.addAttribute("retrievedPost", postDao.getById(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String getCreateForm(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createNewPost(@RequestParam(name="title") String title, @RequestParam(name="body") String body, Model model){
        Post newPost = new Post(title, body);
        postDao.save(newPost);
        return "redirect:/posts";
    }
}