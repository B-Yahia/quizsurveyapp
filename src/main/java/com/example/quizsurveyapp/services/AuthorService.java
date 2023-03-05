package com.example.quizsurveyapp.services;

import com.example.quizsurveyapp.controllers.DTO.AuthorDTO;
import com.example.quizsurveyapp.controllers.authentication.AuthenticationResponse;
import com.example.quizsurveyapp.exception.ResourceNotFoundException;
import com.example.quizsurveyapp.models.Author;
import com.example.quizsurveyapp.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addAuthor (Author author){
        author.setPassword(passwordEncoder.encode(author.getPassword()));
        authorRepository.save(author);
        return "added to DB";
    }

    public AuthenticationResponse getAuthenticationResponse(String username) {
        Author author = authorRepository.findByUsername(username).orElseThrow(()-> new ResourceNotFoundException("Quiz no found"));
        return new AuthenticationResponse(author.getId(),author.getUsername());
    }

    public AuthorDTO getAuthorInfo (long id){
        Author author = authorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Quiz no found"));
        return new AuthorDTO(author.getId(),author.getFirstName(),author.getLastName(),author.getUsername(),author.getEmail(),author.getDateOfBirth());

    }
}
