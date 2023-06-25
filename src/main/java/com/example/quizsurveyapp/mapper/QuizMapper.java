package com.example.quizsurveyapp.mapper;

import com.example.quizsurveyapp.dto.QuestionDTO;
import com.example.quizsurveyapp.dto.QuizDTO;
import com.example.quizsurveyapp.models.Question;
import com.example.quizsurveyapp.models.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuizMapper {
    @Autowired
    private QuestionMapper questionMapper;


    public QuizDTO toDTO(Quiz quiz) {
        QuizDTO dto = new QuizDTO();
        dto.setId(quiz.getId());
        dto.setTitle(quiz.getTitle());
        dto.setDescription(quiz.getDescription());
        dto.setCategory(quiz.getCategory());
        dto.setTags(quiz.getTags());
        List<QuestionDTO> questionDTOList = quiz.getQuestions().stream().map(questionMapper::toDTO).collect(Collectors.toList());
        dto.setQuestions(questionDTOList);
        dto.setParticipationList(quiz.getParticipationList());
        return dto;
    }

    public Quiz toEntity(QuizDTO quizDTO) {
        Quiz quiz = new Quiz();
        quiz.setTitle(quizDTO.getTitle());
        quiz.setDescription(quizDTO.getDescription());
        quiz.setCategory(quizDTO.getCategory());
        quiz.setTags(quizDTO.getTags());
        List<Question> questionList = quizDTO.getQuestions().stream().map(questionMapper::toEntity).collect(Collectors.toList());
        quiz.setQuestions(questionList);
        quiz.setParticipationList(quizDTO.getParticipationList());
        quiz.setPublicAccess(quizDTO.isPublicAccess());
        quiz.setAvailable(true);
        return quiz;
    }
}