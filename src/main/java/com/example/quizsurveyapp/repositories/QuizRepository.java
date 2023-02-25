package com.example.quizsurveyapp.repositories;

import com.example.quizsurveyapp.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
