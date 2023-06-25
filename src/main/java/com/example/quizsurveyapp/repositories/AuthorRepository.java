package com.example.quizsurveyapp.repositories;

import com.example.quizsurveyapp.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AuthorRepository extends JpaRepository<Author,Long>{

    Optional<Author> findByUsername(String username);
    Optional<Author> findByUsernameOrEmail(String username, String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    List<Author> findByAvailableTrue();
}
