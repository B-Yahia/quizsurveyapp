package com.example.quizsurveyapp.mapper;


import com.example.quizsurveyapp.dto.AuthorDTO;
import com.example.quizsurveyapp.dto.QuizDTO;
import com.example.quizsurveyapp.models.Author;
import com.example.quizsurveyapp.models.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorMapper {
    @Autowired
    private QuizMapper quizMapper;

    public AuthorDTO toDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setFirstName(author.getFirstName());
        authorDTO.setLastName(author.getLastName());
        authorDTO.setUsername(author.getUsername());
        authorDTO.setEmail(author.getEmail());
        authorDTO.setDateOfBirth(author.getDateOfBirth());
        authorDTO.setAvailable(author.isAvailable());
        List<QuizDTO> quizDTOList = author.getQuizzes().stream().map(quizMapper::toDTO).collect(Collectors.toList());
        authorDTO.setQuizzes(quizDTOList);
        return authorDTO;
    }

    public Author toEntity(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setUsername(authorDTO.getUsername());
        author.setEmail(authorDTO.getEmail());
        author.setDateOfBirth(authorDTO.getDateOfBirth());
        author.setAvailable(authorDTO.isAvailable());
        List<Quiz> quizList = authorDTO.getQuizzes().stream().map(quizMapper::toEntity).collect(Collectors.toList());
        author.setQuizzes(quizList);
        return author;
    }
}
