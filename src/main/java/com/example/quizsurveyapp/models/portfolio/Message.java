package com.example.quizsurveyapp.models.portfolio;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
