package com.example.quizsurveyapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuizDTOPage {

    private List<QuizDTO> quizDTOList;
    private int pageIndex;
    private int numberOfPages;
    private boolean lastPage;
    private boolean firstPage;

    public QuizDTOPage(List<QuizDTO> quizDTOList, int pageIndex, int numberOfPages, boolean lastPage, boolean firstPage) {
        this.quizDTOList = quizDTOList;
        this.pageIndex = pageIndex;
        this.numberOfPages = numberOfPages;
        this.lastPage = lastPage;
        this.firstPage = firstPage;
    }
}
