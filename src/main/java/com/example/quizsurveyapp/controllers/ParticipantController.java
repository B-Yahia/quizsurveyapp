package com.example.quizsurveyapp.controllers;

import com.example.quizsurveyapp.models.Participation;
import com.example.quizsurveyapp.models.Quiz;
import com.example.quizsurveyapp.services.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("/participant")
public class ParticipantController {
    @Autowired
    private ParticipationService participationService;

    @PostMapping("/add/{id}")
    public ResponseEntity<Quiz> saveParticipant(@PathVariable long id , @RequestBody Participation participant){
        Quiz quiz = participationService.addParticipationToQuiz(participant,id);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }


}
