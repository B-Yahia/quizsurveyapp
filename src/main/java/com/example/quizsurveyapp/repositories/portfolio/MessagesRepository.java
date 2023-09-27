package com.example.quizsurveyapp.repositories.portfolio;

import com.example.quizsurveyapp.models.portfolio.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends JpaRepository<Message,Long> {
}
