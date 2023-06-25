package com.example.quizsurveyapp.services;

import com.example.quizsurveyapp.models.QuestionResponse;
import com.example.quizsurveyapp.repositories.QuestionResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionResponseService {
    @Autowired
    private QuestionResponseRepository questionResponseRepository;

    public List<QuestionResponse> saveAll(List<QuestionResponse> questionResponseList){
        return questionResponseRepository.saveAll(questionResponseList);
    }
}
