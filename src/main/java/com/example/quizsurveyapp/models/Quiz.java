package com.example.quizsurveyapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Please add the quiz title")
    private String title;
    @NotBlank(message = "Please add the quiz description")
    private String description;
    private String  category;
    @ElementCollection
    private List<String> tags;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Question> questions;
    @OneToMany (cascade = CascadeType.ALL)
    private List<Participation> participationList;
    @Column(columnDefinition="tinyint(1) default 1")
    private boolean available;
    @Column(columnDefinition="tinyint(1) default 1")
    private boolean publicAccess;
}
