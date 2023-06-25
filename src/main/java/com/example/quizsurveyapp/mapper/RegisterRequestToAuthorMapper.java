package com.example.quizsurveyapp.mapper;

import com.example.quizsurveyapp.controllers.authentication.RegisterRequest;
import com.example.quizsurveyapp.models.Author;
import org.springframework.stereotype.Component;

@Component
public class RegisterRequestToAuthorMapper {

    public Author toAuthor(RegisterRequest registerRequest) {
        Author author = new Author();
        author.setFirstName(registerRequest.getFirstName());
        author.setLastName(registerRequest.getLastName());
        author.setUsername(registerRequest.getUsername());
        author.setEmail(registerRequest.getEmail());
        author.setDateOfBirth(registerRequest.getDateOfBirth());
        author.setPassword(registerRequest.getPassword());
        author.setAvailable(true);
        return author;
    }
}