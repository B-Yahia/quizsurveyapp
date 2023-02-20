package com.example.quizsurveyapp.services;

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
}
