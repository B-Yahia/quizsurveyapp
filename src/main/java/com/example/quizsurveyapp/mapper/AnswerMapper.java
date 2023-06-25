package com.example.quizsurveyapp.mapper;

import com.example.quizsurveyapp.dto.AnswerDTO;
import com.example.quizsurveyapp.models.Answer;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {
    public AnswerDTO toDTO(Answer answer) {
        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setId(answer.getId());
        answerDTO.setStatement(answer.getStatement());
        answerDTO.setCorrect(answer.isCorrect());
        return answerDTO;
    }

    public Answer toEntity(AnswerDTO answerDTO) {
        Answer answer = new Answer();
        answer.setId(answerDTO.getId());
        answer.setStatement(answerDTO.getStatement());
        answer.setCorrect(answerDTO.isCorrect());
        answer.setAvailable(true);
        return answer;
    }
}
