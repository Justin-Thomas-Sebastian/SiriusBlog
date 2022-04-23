package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String index(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable long id, Model model){
        model.addAttribute("retrievedPost", postDao.getById(id));
        model.addAttribute("retrievedEmail", postDao.getById(id).getUser().getEmail());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String getCreateForm(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createNewPost(@RequestParam(name="title") String title, @RequestParam(name="body") String body, Model model){
        User testUser = userDao.getById(1L);
        Post newPost = new Post(title, body, testUser);
        postDao.save(newPost);
        return "redirect:/posts";
    }
}