package com.example.quizsurveyapp.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp = ("\\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+"),
            message = "The First name can only contain letters and the first letter must start with an uppercase")
    private String firstName;
    @Pattern(regexp = ("\\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+"),
            message = "The Last name can only contain letters and the first letter must start with an uppercase")
    private String lastName;
    @Column(name = "username", unique=true)
    private String username;
    @Size(min = 8, max = 32, message = "Password must be between 8 and 32 characters")
    private String password;
    @Column(name = "email", unique=true)
    @Email(message = "Invalid email")
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private boolean available;
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Quiz> quizzes = new ArrayList<>();;


    public void addQuiz(Quiz quiz) {
        this.quizzes.add(quiz);
    }
}
