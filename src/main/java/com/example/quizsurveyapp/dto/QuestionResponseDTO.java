package com.example.quizsurveyapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseDTO {
    private Long id;
    private QuestionDTO questionDTO;
    private List<Long> selectedAnswerIds;
    private boolean correct;
}
