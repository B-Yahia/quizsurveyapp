package com.example.quizsurveyapp.dto;

import com.example.quizsurveyapp.models.Participation;
import com.example.quizsurveyapp.models.Question;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizDTO {
    private long id;
    @NotBlank(message = "Please add the quiz title")
    private String title;
    @NotBlank(message = "Please add the quiz description")
    private String description;
    private String category;
    private List<String> tags;
    private List<QuestionDTO> questions;
    private List<Participation> participationList;
    private boolean publicAccess;
}
