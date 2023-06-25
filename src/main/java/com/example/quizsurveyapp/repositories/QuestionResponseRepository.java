package com.example.quizsurveyapp.repositories;

import com.example.quizsurveyapp.models.QuestionResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionResponseRepository extends JpaRepository<QuestionResponse,Long> {
}
