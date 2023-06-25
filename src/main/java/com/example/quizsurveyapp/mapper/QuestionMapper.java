package com.example.quizsurveyapp.mapper;


import com.example.quizsurveyapp.dto.AnswerDTO;
import com.example.quizsurveyapp.dto.QuestionDTO;
import com.example.quizsurveyapp.models.Answer;
import com.example.quizsurveyapp.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionMapper {

    @Autowired
    private AnswerMapper answerMapper;

    public QuestionDTO toDTO(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setStatement(question.getStatement());
        List<AnswerDTO> answers = question.getAnswers().stream()
                .map(answerMapper::toDTO)
                .collect(Collectors.toList());
        questionDTO.setAnswers(answers);
        return questionDTO;
    }

    public Question toEntity(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setId(questionDTO.getId());
        question.setStatement(questionDTO.getStatement());
        List<Answer> answers = questionDTO.getAnswers().stream()
                .map(answerMapper::toEntity)
                .collect(Collectors.toList());
        question.setAnswers(answers);
        question.setAvailable(true);
        return question;
    }
}
