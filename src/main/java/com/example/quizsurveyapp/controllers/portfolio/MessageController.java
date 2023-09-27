package com.example.quizsurveyapp.controllers.portfolio;

import com.example.quizsurveyapp.dto.protfolio.MessageDTO;
import com.example.quizsurveyapp.mapper.portfolio.MessageMapper;
import com.example.quizsurveyapp.models.portfolio.Message;
import com.example.quizsurveyapp.services.portfolio.MessagesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/msg")
@CrossOrigin(origins = "*" )
public class MessageController {
    @Autowired
    private MessagesService messagesService;
    @Autowired
    private MessageMapper messageMapper;

    @PostMapping
    public ResponseEntity<MessageDTO> createMessage (@Valid @RequestBody MessageDTO messageDTO){
        var message = messagesService.saveMessage(messageMapper.toEntity(messageDTO));
        return new ResponseEntity<>(messageMapper.toDTO(message), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getMessageByID (@PathVariable long id){
        return new ResponseEntity<>(messageMapper.toDTO(messagesService.getMessageById(id)),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MessageDTO>> getAllMessages (){
        List<Message> messages = messagesService.getAllMessages();
        return new ResponseEntity<>(messages.stream().map(messageMapper::toDTO).collect(Collectors.toList()), HttpStatus.OK);
    }
}
