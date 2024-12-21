package com.Quiz_App.quiz.App.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class QuizSummaryDTO {

    private Long sessionId;
    private int totalQuestions;
    private int correctAnswers;
    private int notAttempted;
    private int score;
    private String remark;

}
