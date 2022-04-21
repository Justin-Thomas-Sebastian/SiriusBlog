package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.Post;
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
//        model.addAttribute("posts", postDao.findAll());   * part of jpa exercise*
        ArrayList<Post> indexPosts = new ArrayList<>();
        indexPosts.add(new Post("index post title 1", "index post body 1"));
        indexPosts.add(new Post("index post title 2", "index post body 2"));
        model.addAttribute("indexPosts", indexPosts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable long id, Model model){
        Post post = new Post("test title", "test body");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String getCreateForm(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createNewPost(Post post){
        //set inputted post from into db
        return "redirect:/posts";
    }
}