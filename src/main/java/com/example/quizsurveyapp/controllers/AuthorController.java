package com.example.quizsurveyapp.controllers;

import com.example.quizsurveyapp.dto.AuthorDTO;
import com.example.quizsurveyapp.mapper.AuthorMapper;
import com.example.quizsurveyapp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/author")
@CrossOrigin(origins = "*" )
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthorMapper authorMapper;

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthors(@PathVariable long id){
        var author = authorService.getAuthorById(id);
        return  new ResponseEntity<>(authorMapper.toDTO(author), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors(){
        var authors = authorService.getAllAuthors();
        var authorsDTO = authors.stream().map(authorMapper::toDTO).collect(Collectors.toList());
        return  new ResponseEntity<>(authorsDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpStatus removeAuthor (@PathVariable long id){
        authorService.editAvailableStatus(id);
        return HttpStatus.OK;
    }

}
