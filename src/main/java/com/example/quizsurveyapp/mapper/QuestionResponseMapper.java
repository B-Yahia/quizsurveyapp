package com.example.quizsurveyapp.mapper;

import com.example.quizsurveyapp.dto.QuestionResponseDTO;
import com.example.quizsurveyapp.models.QuestionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionResponseMapper {
    @Autowired
    private QuestionMapper questionMapper;

    public QuestionResponseDTO toDTO(QuestionResponse questionResponse) {
        QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO();
        questionResponseDTO.setId(questionResponse.getId());
        questionResponseDTO.setQuestionDTO(questionMapper.toDTO(questionResponse.getQuestion()));
        questionResponseDTO.setSelectedAnswerIds(questionResponse.getSelectedAnswerIds());
        return questionResponseDTO;
    }

    public QuestionResponse toEntity(QuestionResponseDTO questionResponseDTO) {
        QuestionResponse questionResponse = new QuestionResponse();
        questionResponse.setId(questionResponseDTO.getId());
        questionResponse.setQuestion(questionMapper.toEntity(questionResponseDTO.getQuestionDTO()));
        questionResponse.setSelectedAnswerIds(questionResponseDTO.getSelectedAnswerIds());
        return questionResponse;
    }
}
