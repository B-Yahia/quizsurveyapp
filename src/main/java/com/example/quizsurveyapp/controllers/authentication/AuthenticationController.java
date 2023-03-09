package com.example.quizsurveyapp.controllers.authentication;

import com.example.quizsurveyapp.exception.ResourceNotFoundException;
import com.example.quizsurveyapp.models.Author;
import com.example.quizsurveyapp.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*" )
public class AuthenticationController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @CrossOrigin(origins = "*" )
    @PostMapping("/register")
    public ResponseEntity<String> registerAuthor( @Valid @RequestBody Author author){
        authorService.addAuthor(author);
        return new ResponseEntity<String>("added", HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*" )
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticateAuthor(@Valid @RequestBody AuthenticationRequest authenticationRequest ){
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AuthenticationResponse authenticationResponse = authorService.getAuthenticationResponse(authenticationRequest.getUsername());
        return new ResponseEntity<>(authenticationResponse,HttpStatus.OK);
    }
    @GetMapping("/test")
    public ResponseEntity<String> test(){

        throw new ResourceNotFoundException("nod");
    }

}
