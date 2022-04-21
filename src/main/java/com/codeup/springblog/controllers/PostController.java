package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "index";
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable String id, Model model){
        model.addAttribute("postId", postDao.findById(Long.valueOf(id)));
        return "index";
    }

    @GetMapping("/posts/create")
    public String getCreateForm(){
        return "create";
    }

    @PostMapping("/posts/create")
    public String createNewPost(Post post){
        //set inputted post from into db
        return "redirect:/posts";
    }
}