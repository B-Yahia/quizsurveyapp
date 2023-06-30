package com.example.quizsurveyapp.dto;

import com.example.quizsurveyapp.models.Answer;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionDTO {
    private Long id;
    @NotBlank(message = "Please write a question")
    private String statement;
    private List<AnswerDTO> answers = new ArrayList<>();;
    private int numberOfCorrectAnswers ;
}
