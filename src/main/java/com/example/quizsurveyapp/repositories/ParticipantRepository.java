package com.example.quizsurveyapp.repositories;

import com.example.quizsurveyapp.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {
}
