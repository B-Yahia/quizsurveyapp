package com.example.quizsurveyapp.dto.protfolio;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MessageDTO {
    private Long id;

    @NotBlank(message = "Please write your name ")
    private String name;

    @NotBlank(message = "The msg field can not be empty ")
    private String msg;

    @Email(message = "Make sure that the email address is correct")
    private String email;

    private String phoneNumber;

    private boolean seen;


}
