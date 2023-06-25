package com.example.quizsurveyapp.controllers;

import com.example.quizsurveyapp.dto.AnswerDTO;
import com.example.quizsurveyapp.mapper.AnswerMapper;
import com.example.quizsurveyapp.models.Answer;
import com.example.quizsurveyapp.services.AnswerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @Autowired
    private AnswerMapper answerMapper;

    @PostMapping
    public ResponseEntity<AnswerDTO> createAnswer(@Valid @RequestBody AnswerDTO answerDTO){
        var answer = answerService.saveAnswer(answerMapper.toEntity(answerDTO));
        return new ResponseEntity<>(answerMapper.toDTO(answer), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerDTO> getAnswerById(@PathVariable Long id){
       var answer = answerService.findAnswerByID(id);
        return new ResponseEntity<>(answerMapper.toDTO(answer), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<AnswerDTO>> getAllAnswer(){
        var answers = answerService.getAllAnswers();
        var answersDTO =answers.stream().map(answerMapper::toDTO).collect(Collectors.toList());
        return new ResponseEntity<>(answersDTO, HttpStatus.OK);
    }

    @PutMapping("/remove/{id}")
    public HttpStatus removeAnswer (@PathVariable Long id){
        answerService.removeAnswer(id);
        return HttpStatus.OK;
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<AnswerDTO> editeAnswerStatus (@PathVariable Long id){
        var answer = answerService.editeAnswerStatus(id);
        return new ResponseEntity<>(answerMapper.toDTO(answer), HttpStatus.OK);
    }


}
