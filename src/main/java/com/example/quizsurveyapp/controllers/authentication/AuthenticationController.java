package com.example.quizsurveyapp.controllers.authentication;

import com.example.quizsurveyapp.models.Author;
import com.example.quizsurveyapp.services.AuthenticationService;
import com.example.quizsurveyapp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<String> registerAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
        return new ResponseEntity<String>("added", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateAuthor(@RequestBody AuthenticationRequest authenticationRequest ){
        System.out.println(authenticationRequest.toString());

        authenticationService.authenticate(authenticationRequest);
        return new ResponseEntity<String>("correct",HttpStatus.ACCEPTED);
    }

}
