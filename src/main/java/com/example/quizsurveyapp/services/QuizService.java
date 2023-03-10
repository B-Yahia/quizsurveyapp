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
    private AuthorRepository authorRepository;
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionService questionService;


    public Quiz createQuizAndAddAuthor(Quiz quiz , long authorId){
        Author author = authorRepository.findById(authorId).orElseThrow(()-> new ResourceNotFoundException("Author no found"));
        List<Question> questions = new ArrayList<>();
        for (Question q : quiz.getQuestions()) {
            Question newQuestion = questionService.createQuestion(q);
            questions.add(newQuestion);
        }
        Quiz newQuiz = new Quiz();
        newQuiz.setAuthor(author);
        newQuiz.setAvailable(quiz.isAvailable());
        newQuiz.setQuestions(questions);
        newQuiz.setDescription(quiz.getDescription());
        newQuiz.setCategory(quiz.getCategory());
        newQuiz.setTitle(quiz.getTitle());
        newQuiz.setPublic(quiz.isPublic());
        newQuiz.setTags(quiz.getTags());
        return newQuiz;
    }
    public Quiz saveQuiz (Quiz quiz) {
        return quizRepository.save(quiz);
    }
    public void editPublicStatus( long quizId){
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(()-> new ResourceNotFoundException("Quiz no found"));
        quiz.setPublic(!quiz.isPublic());
        saveQuiz(quiz);
    }
    public void editAvailableStatus( long quizId){
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(()-> new ResourceNotFoundException("Quiz no found"));
        quiz.setAvailable(!quiz.isAvailable());
        saveQuiz(quiz);
    }

    public List<Quiz> getAllQuizzes ( ){
        return quizRepository.findAll();
    }
    public List<Quiz> getUserQuizzes ( long userID){
        List<Quiz> userQuizzes = getAllQuizzes();
        userQuizzes.removeIf(quiz -> quiz.getAuthor().getId()!=userID);
        userQuizzes.removeIf(quiz -> quiz.isAvailable()== false);
        return userQuizzes;
    }
    public Quiz getQuizById( long quizId){
        return quizRepository.findById(quizId).orElseThrow(()-> new ResourceNotFoundException("Quiz no found"));
    }

    public List<Quiz> getAllQuizzesSorted ( String propriety){
        return quizRepository.findAll(Sort.by(propriety));
    }

    public Page<Quiz> getAllQuizzesWithPagination (int offSet ,int pageSize ){
//        List<Quiz> userQuizzes = getAllQuizzes();
//        userQuizzes.removeIf(quiz -> quiz.isPublic()==false);
//        Pageable pageable = PageRequest.of(offSet, pageSize);
//        Page<Quiz> page = new PageImpl<>(userQuizzes, pageable, userQuizzes.size());

       Page<Quiz> quizPage = quizRepository.findPublicQuizzes(PageRequest.of(offSet, pageSize));


        return quizPage;
    }
}
