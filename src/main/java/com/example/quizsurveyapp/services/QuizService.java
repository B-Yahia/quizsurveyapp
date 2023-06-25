package com.example.quizsurveyapp.services;

import com.example.quizsurveyapp.exception.ResourceNotFoundException;
import com.example.quizsurveyapp.models.Author;
import com.example.quizsurveyapp.models.Question;
import com.example.quizsurveyapp.models.Quiz;
import com.example.quizsurveyapp.repositories.AnswerRepository;
import com.example.quizsurveyapp.repositories.AuthorRepository;
import com.example.quizsurveyapp.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionService questionService;


    public Quiz createQuizAndAddAuthor(Quiz quiz , long authorId){
        var author = authorService.getAuthorById(authorId);
        var newQuiz=saveQuiz(quiz);
        author.addQuiz(newQuiz);
        authorService.saveAuthor(author);
        return newQuiz;
    }

    public Quiz getQuizById( long quizId){
        var quiz= quizRepository.findById(quizId).orElseThrow(()-> new ResourceNotFoundException("Quiz no found"));
        if (quiz.isAvailable()){
            return quiz;
        }else {
            throw new ResourceNotFoundException("Quiz has been removed");
        }
    }

    public Quiz saveQuiz (Quiz quiz) {
        return quizRepository.save(quiz);
    }
    public Quiz editPublicStatus( long quizId){
        var quiz = getQuizById(quizId);
        quiz.setPublicAccess(!quiz.isPublicAccess());
        return saveQuiz(quiz);
    }
    public Quiz editAvailableStatus( long quizId){
        Quiz quiz = getQuizById(quizId);
        quiz.setAvailable(!quiz.isAvailable());
        return saveQuiz(quiz);
    }

    public List<Quiz> getAllQuizzes ( ){
        var quizList= quizRepository.findAll();
        quizList.removeIf(quiz -> quiz.isAvailable()==false);
        return quizList;
    }



    public List<Quiz> getAllQuizzesSorted ( String propriety){
        return quizRepository.findAll(Sort.by(propriety));
    }

    public Page<Quiz> getAllQuizzesWithPagination (int offSet ,int pageSize ){
//        List<Quiz> userQuizzes = getAllQuizzes();
//        userQuizzes.removeIf(quiz -> quiz.isPublic()==false);
//        Pageable pageable = PageRequest.of(offSet, pageSize);
//        Page<Quiz> page = new PageImpl<>(userQuizzes, pageable, userQuizzes.size());
//
//       Page<Quiz> quizPage = quizRepository.findPublicQuizzes(PageRequest.of(offSet, pageSize));


        return null;
    }
}
