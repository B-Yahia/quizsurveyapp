package com.example.quizsurveyapp.controllers;

import com.example.quizsurveyapp.dto.QuestionDTO;
import com.example.quizsurveyapp.mapper.QuestionMapper;
import com.example.quizsurveyapp.models.Question;
import com.example.quizsurveyapp.models.Quiz;
import com.example.quizsurveyapp.services.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionMapper questionMapper;

    @PostMapping
    public ResponseEntity<QuestionDTO> createQuestion( @Valid @RequestBody QuestionDTO questionDTO){
        var question = questionService.saveQuestion(questionMapper.toEntity(questionDTO));
        return new ResponseEntity<>(questionMapper.toDTO(question), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> getQuestionById(@PathVariable Long id){
        var question = questionService.getQuestionById(id);
        return new ResponseEntity<>(questionMapper.toDTO(question),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<QuestionDTO>> getAllQuestions(){
        var questions = questionService.getAllQuestions();
        var questionsDTO = questions.stream().map(questionMapper::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(questionsDTO,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public HttpStatus removeQuestion (@PathVariable Long id){
        questionService.updateQuestionAvailableStatus(id);
        return HttpStatus.OK;
    }

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
