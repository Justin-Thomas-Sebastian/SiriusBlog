package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String getPosts(){
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String getPostById(@PathVariable String id){
        return "View post id: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreateForm(){
        return "view the form for creating a post " +
                "<form action='/posts/create' method='post'>" +
                "<input type=text name='content' id='content'>" +
                "<input type=submit value='postTest'>" +
                "</form>";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost(@RequestParam(name = "content") String contentValue){
        System.out.println("contentValue = " + contentValue);
        return "create a new post: " + contentValue;
    }
}
