package com.example.quizsurveyapp.mapper.portfolio;

import com.example.quizsurveyapp.dto.protfolio.MessageDTO;
import com.example.quizsurveyapp.models.portfolio.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {
    public MessageDTO toDTO(Message message) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setName(message.getName());
        messageDTO.setEmail(message.getEmail());
        messageDTO.setMsg(message.getMsg());
        messageDTO.setPhoneNumber(message.getPhoneNumber());
        messageDTO.setSeen(message.isSeen());
        return messageDTO;
    }

    public Message toEntity(MessageDTO messageDTO) {
        Message message = new Message();
        message.setId(messageDTO.getId());
        message.setName(messageDTO.getName());
        message.setEmail(messageDTO.getEmail());
        message.setMsg(messageDTO.getMsg());
        message.setPhoneNumber(messageDTO.getPhoneNumber());
        message.setSeen(messageDTO.isSeen());
        return message;
    }
}
