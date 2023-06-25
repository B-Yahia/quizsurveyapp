package com.example.quizsurveyapp.services;

import com.example.quizsurveyapp.exception.ResourceNotFoundException;
import com.example.quizsurveyapp.models.Question;
import com.example.quizsurveyapp.models.Quiz;
import com.example.quizsurveyapp.repositories.AnswerRepository;
import com.example.quizsurveyapp.repositories.QuestionRepository;
import com.example.quizsurveyapp.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private AnswerRepository answerRepository;

    public Question saveQuestion(Question question){
        return questionRepository.save(question);
    }
    public Question getQuestionById (Long id){
        var question = questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Question not found"));
        if (question.isAvailable()){
            return question;
        }else {
            throw new ResourceNotFoundException("Question has been deleted");
        }
    }
    public List<Question> getAllQuestions(){
        var questions = questionRepository.findAll();
        questions.removeIf(question -> question.isAvailable()==false);
        return questions;
    }

    public void updateQuestionAvailableStatus (Long id){
       var question = getQuestionById(id);
       question.setAvailable(!question.isAvailable());
       saveQuestion(question);
    }

    public Quiz addQuestionToQuiz (Question question, long quizID){
        Quiz quiz = quizRepository.findById(quizID).orElseThrow(()-> new ResourceNotFoundException("Quiz not found"));
        quiz.getQuestions().add(saveQuestion(question));
        return quizRepository.save(quiz);
    }
    public Question editAvailableStatus (long id){
        Question question = questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Quiz not found"));
        question.setAvailable(!question.isAvailable());
        return questionRepository.save(question);
    }

}
