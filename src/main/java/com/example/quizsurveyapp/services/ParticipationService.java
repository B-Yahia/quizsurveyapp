package com.example.quizsurveyapp.services;

import com.example.quizsurveyapp.exception.ResourceNotFoundException;
import com.example.quizsurveyapp.models.Participation;
import com.example.quizsurveyapp.models.Quiz;
import com.example.quizsurveyapp.repositories.ParticipationRepository;
import com.example.quizsurveyapp.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private ParticipationRepository participantRepository;


    public Quiz addParticipationToQuiz (Participation participant, long id){
        Quiz quiz= quizRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Quiz not found"));
        Participation participant1 = saveParticipant(participant);
        List<Participation> participantList =quiz.getParticipationList();
        participantList.add(participant1);
        quiz.setParticipationList(participantList);
        return quizRepository.save(quiz);
    }

    Participation saveParticipant (Participation participant){
        return participantRepository.save(participant);
    }
}
