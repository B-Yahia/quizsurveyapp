package com.example.quizsurveyapp.controllers;

import com.example.quizsurveyapp.models.Question;
import com.example.quizsurveyapp.models.Quiz;
import com.example.quizsurveyapp.services.QuestionService;
import com.example.quizsurveyapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/add/{id}")
    public ResponseEntity<Quiz> addQuestion (@PathVariable Long id, @RequestBody Question question){
        Quiz quiz = questionService.addQuestionToQuiz(question,id);
        return new ResponseEntity<>(quiz, HttpStatus.CREATED);
    }
    @PostMapping("/remove/{id}")
    public ResponseEntity<Question> editQuestionStatus (@PathVariable Long id){
        Question question = questionService.editAvailableStatus(id);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }
}
