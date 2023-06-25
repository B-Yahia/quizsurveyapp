package com.example.quizsurveyapp.repositories;

import com.example.quizsurveyapp.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
    List<Answer> findByAvailableTrue();
}
