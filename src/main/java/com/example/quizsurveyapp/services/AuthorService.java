package com.example.quizsurveyapp.services;

import com.example.quizsurveyapp.controllers.authentication.AuthenticationRequest;
import com.example.quizsurveyapp.controllers.authentication.AuthenticationResponse;
import com.example.quizsurveyapp.exception.ResourceNotFoundException;
import com.example.quizsurveyapp.models.Author;
import com.example.quizsurveyapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    public Author saveAuthor (Author author){
        return authorRepository.save(author);
    }

    public AuthenticationResponse getAuthenticationResponse(AuthenticationRequest authenticationRequest) {
        var author = authorRepository.findByUsername(authenticationRequest.getUsername()).orElseThrow(()-> new ResourceNotFoundException("User does not exist"));
        if (author.getPassword().equals(authenticationRequest.getPassword())){
            return new AuthenticationResponse(author.getId(),author.getUsername());
        } else {
            throw new ResourceNotFoundException("Password or username is incorrect");
        }
    }

    public Author getAuthorById(long id){
        var author= authorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Quiz no found"));
        author.getQuizzes().removeIf(quiz -> quiz.isAvailable()==false);
        if (author.isAvailable()){
            return author;
        }else {
            throw new ResourceNotFoundException("User has been removed");
        }
    }

    public List<Author> getAllAuthors (){
        var authors= authorRepository.findAll();
        authors.removeIf(author -> author.isAvailable()==false);
        return authors;
    }

    public Author editAvailableStatus (long id){
        Author author = getAuthorById(id);
        author.setAvailable(!author.isAvailable());
        return saveAuthor(author);
    }
}
