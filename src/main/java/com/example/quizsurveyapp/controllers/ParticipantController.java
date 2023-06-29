package com.example.quizsurveyapp.controllers;

import com.example.quizsurveyapp.dto.ParticipationDTO;
import com.example.quizsurveyapp.mapper.ParticipationMapper;
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
    @Autowired
    private ParticipationMapper participationMapper;

    @PostMapping
    public ResponseEntity<ParticipationDTO> saveParticipant(@RequestBody ParticipationDTO participationDTO){
        var participation = participationService.addParticipationToQuiz(participationMapper.toEntity(participationDTO));
        return new ResponseEntity<>(participationMapper.toDTO(participation), HttpStatus.OK);
    }


}
