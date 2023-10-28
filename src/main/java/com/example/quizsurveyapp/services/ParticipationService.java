package com.example.quizsurveyapp.services;

import com.example.quizsurveyapp.models.Answer;
import com.example.quizsurveyapp.models.Participation;
import com.example.quizsurveyapp.models.QuestionResponse;
import com.example.quizsurveyapp.repositories.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipationService {
    @Autowired
    private QuizService quizService;
    @Autowired
    private ParticipationRepository participantRepository;
    @Autowired
    private AnswerService answerService;

    public Participation addParticipationToQuiz (Participation participant){
        var quiz= quizService.getQuizById(participant.getQuizId());
        participant.setScore(calculateScore(participant.getQuestionResponseList()));
        saveParticipant(participant);
        quiz.addParticipation(participant);
        quizService.saveQuiz(quiz);
        return participant;
    }

    Participation saveParticipant (Participation participant){
        return participantRepository.save(participant);
    }

    public float calculateScore (List<QuestionResponse> questionResponseList){
        float score = 0 ;

        for (QuestionResponse qr:questionResponseList) {
            qr.setCorrect(true);
            List<Answer> correctAnswers = qr.getQuestion().getAnswers().stream().filter(answer -> answer.isCorrect()).collect(Collectors.toList());
            if (qr.getSelectedAnswerIds().size()== correctAnswers.size()){
                for (Long selectedAnswerId: qr.getSelectedAnswerIds()) {
                    var selectedAnswerEntity = answerService.findAnswerByID(selectedAnswerId);
                    if (!selectedAnswerEntity.isCorrect()){
                        qr.setCorrect(false);
                    }
                }
            }else {
                qr.setCorrect(false);
            }
            if (qr.isCorrect()){
                score=score+1;
            }
        }
        return score;
    }
}
