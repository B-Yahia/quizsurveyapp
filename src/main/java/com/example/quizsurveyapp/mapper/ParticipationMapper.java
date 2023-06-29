package com.example.quizsurveyapp.mapper;

import com.example.quizsurveyapp.dto.ParticipationDTO;
import com.example.quizsurveyapp.dto.QuestionResponseDTO;
import com.example.quizsurveyapp.models.Participation;
import com.example.quizsurveyapp.models.QuestionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParticipationMapper {
    @Autowired
    private QuestionResponseMapper questionResponseMapper;

    public ParticipationDTO toDTO(Participation participation) {
        ParticipationDTO participationDTO = new ParticipationDTO();
        participationDTO.setId(participation.getId());
        participationDTO.setFirstName(participation.getFirstName());
        participationDTO.setLastName(participation.getLastName());
        participationDTO.setScore(participation.getScore());
        participationDTO.setQuizId(participation.getQuizId());
        List<QuestionResponseDTO> questionResponseDTOList = participation.getQuestionResponseList().stream()
                .map(questionResponseMapper::toDTO)
                .collect(Collectors.toList());

        participationDTO.setQuestionResponseList(questionResponseDTOList);

        return participationDTO;
    }

    public Participation toEntity(ParticipationDTO participationDTO) {
        Participation participation = new Participation();
        participation.setId(participationDTO.getId());
        participation.setFirstName(participationDTO.getFirstName());
        participation.setLastName(participationDTO.getLastName());
        participation.setScore(participationDTO.getScore());
        participation.setQuizId(participationDTO.getQuizId());
        List<QuestionResponse> questionResponseList = participationDTO.getQuestionResponseList().stream()
                .map(questionResponseMapper::toEntity)
                .collect(Collectors.toList());
        participation.setQuestionResponseList(questionResponseList);

        return participation;
    }
}
