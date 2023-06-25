package com.example.quizsurveyapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AnswerDTO {
    private Long id;
    @NotBlank(message = "Please write an answer")
    private String statement;
    private boolean correct;
}
