package com.example.quizsurveyapp.services;

import com.example.quizsurveyapp.exception.ResourceNotFoundException;
import com.example.quizsurveyapp.models.Answer;
import com.example.quizsurveyapp.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public Answer saveAnswer (Answer answer){
        return answerRepository.save(answer);
    }

    public List<Answer> saveListOfAnswers (List<Answer> answerList){
        return answerRepository.saveAll(answerList);
    }

    public Answer findAnswerByID (Long id){
        var answer = answerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Answer not found"));
        if (answer.isAvailable()==true){
            return  answer;
        }else {
            throw  new ResourceNotFoundException("This answer has been deleted");
        }
    }
    public void removeAnswer (Long id){
        var answer = findAnswerByID(id);
        answer.setAvailable(!answer.isAvailable());
        saveAnswer(answer);
    }
    public Answer editeAnswerStatus (Long id){
        var answer = findAnswerByID(id);
        answer.setCorrect(!answer.isCorrect());
        return saveAnswer(answer);
    }

    public List<Answer> getAllAnswers(){
        var answers = answerRepository.findAll();
        answers.removeIf(answer -> answer.isAvailable()==false);
        return answers;
    }

}
