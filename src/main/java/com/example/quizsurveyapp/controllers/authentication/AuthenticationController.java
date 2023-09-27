package com.example.quizsurveyapp.controllers.authentication;


import com.example.quizsurveyapp.mapper.RegisterRequestToAuthorMapper;
import com.example.quizsurveyapp.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*" )
public class AuthenticationController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private RegisterRequestToAuthorMapper registerRequestToAuthorMapper;


    @PostMapping("/register")
    public HttpStatus registerAuthor( @Valid @RequestBody RegisterRequest registerRequest){
        authorService.saveAuthor(registerRequestToAuthorMapper.toAuthor(registerRequest));
        return HttpStatus.CREATED;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticateAuthor(@Valid @RequestBody AuthenticationRequest authenticationRequest ){
        AuthenticationResponse authenticationResponse = authorService.getAuthenticationResponse(authenticationRequest);
        return new ResponseEntity<>(authenticationResponse,HttpStatus.OK);
    }


}
