package com.example.quizsurveyapp.controllers;

import com.example.quizsurveyapp.dto.QuizDTO;
import com.example.quizsurveyapp.mapper.QuizMapper;
import com.example.quizsurveyapp.models.Quiz;
import com.example.quizsurveyapp.services.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @Autowired
    private QuizMapper quizMapper;


    @PostMapping("/{id}")
    public ResponseEntity<QuizDTO> addQuiz (@PathVariable Long id,@Valid @RequestBody QuizDTO quizDTO){
        var quiz = quizService.createQuizAndAddAuthor(quizMapper.toEntity(quizDTO),id);
        return new ResponseEntity<>(quizMapper.toDTO(quiz),HttpStatus.CREATED);
    }


    @PutMapping("/public/{id}")
    public ResponseEntity<QuizDTO> editQuizPublicStatus (@PathVariable Long id){
        var quiz = quizService.editPublicStatus(id);
        return new ResponseEntity<>(quizMapper.toDTO(quiz), HttpStatus.OK);
    }

    @PutMapping("/remove/{id}")
    public ResponseEntity<QuizDTO> editAvailableStatus (@PathVariable Long id){
        var quiz =quizService.editAvailableStatus(id);
        return new ResponseEntity<>(quizMapper.toDTO(quiz), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDTO> getQuiz (@PathVariable Long id){
        var quiz = quizService.getQuizById(id);
        return  new ResponseEntity<>(quizMapper.toDTO(quiz),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<QuizDTO>> getAllQuizzes (){
        var quizList = quizService.getAllQuizzes();
        var quizDTOList = quizList.stream().map(quizMapper::toDTO).collect(Collectors.toList());
        return  new ResponseEntity<>(quizDTOList,HttpStatus.OK);
    }


//
//    @GetMapping("/sortedby/{proprety}")
//    public ResponseEntity<List<Quiz>> getAllQuizzesSorted(@PathVariable String proprety){
//        List<Quiz> Quizzes = quizService.getAllQuizzesSorted(proprety);
//        return  new ResponseEntity<>(Quizzes,HttpStatus.OK);
//    }
//    @GetMapping("/pagination/{offSet}/{pageSize}")
//    public ResponseEntity<Page<Quiz>> getAllQuizzesWithPagination(@PathVariable int pageSize, @PathVariable int offSet){
//        Page<Quiz> quizPage = quizService.getAllQuizzesWithPagination(offSet,pageSize);
//        return  new ResponseEntity<>(quizPage,HttpStatus.OK);
//    }


}
