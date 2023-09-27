package com.example.quizsurveyapp.services.portfolio;


import com.example.quizsurveyapp.exception.ResourceNotFoundException;
import com.example.quizsurveyapp.models.portfolio.Message;
import com.example.quizsurveyapp.repositories.portfolio.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessagesService {
    @Autowired
    private MessagesRepository messagesRepository;

    public Message saveMessage (Message message){
        return messagesRepository.save(message);
    }

    public Message getMessageById (long id ){
        return messagesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Message not found"));
    }

    public List<Message> getAllNoneSeeMessages (){
        return messagesRepository.findAll().stream().filter((message)-> message.isSeen()==false).collect(Collectors.toList());
    }

    public List<Message> getAllSeeMessages (){
        return messagesRepository.findAll().stream().filter((message)-> message.isSeen()==true).collect(Collectors.toList());
    }

    public List<Message> getAllMessages (){
        return messagesRepository.findAll();
    }
}
