package com.example.quizsurveyapp.repositories;

import com.example.quizsurveyapp.models.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation,Long> {
}
