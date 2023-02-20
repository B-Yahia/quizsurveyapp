package com.example.quizsurveyapp.controllers;

import com.example.quizsurveyapp.models.Author;
import com.example.quizsurveyapp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/no-security")
    public String hello(){
        return "No security";
    }

    @GetMapping("/security")
    public String hello2(){
        return "security";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String hello3(){
        return "Only admin";
    }

    @PostMapping("/register")
    public String createAuthor (@RequestBody Author author){
        authorService.addAuthor(author);
        return "done";
    }
}
