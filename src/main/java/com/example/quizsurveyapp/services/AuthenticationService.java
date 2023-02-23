package com.example.quizsurveyapp.services;

import com.example.quizsurveyapp.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthorRepository authorRepository;


}
