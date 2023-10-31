package com.example.quizsurveyapp.repositories;

import com.example.quizsurveyapp.models.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

//    @Query("SELECT q FROM Quiz q WHERE q.Public = true")
//    Page<Quiz> findPublicQuizzes(Pageable pageable);

    List<Quiz> findByAvailableTrueAndPublicAccessTrue();
    Page<Quiz> findByAvailableTrue(Pageable pageable);
}
