package com.example.quizsurveyapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipationDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private float score;
    private Long quizId;
    private List<QuestionResponseDTO> questionResponseList= new ArrayList<>();;
}
