package com.example.quizsurveyapp.controllers;

import com.example.quizsurveyapp.models.Quiz;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @PostMapping("/add/{id}")
    public ResponseEntity<String> addQuiz (@PathVariable Long id, @RequestBody Quiz quiz){

        return new ResponseEntity<>("added", HttpStatus.CREATED);
    }
}
