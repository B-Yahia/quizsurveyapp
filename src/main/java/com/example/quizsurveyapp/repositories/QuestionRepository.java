package com.example.quizsurveyapp.repositories;

import com.example.quizsurveyapp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
