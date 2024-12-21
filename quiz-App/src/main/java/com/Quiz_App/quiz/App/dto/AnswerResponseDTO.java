package com.Quiz_App.quiz.App.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnswerResponseDTO {

    private int correctAnswers;
    private int notAttempted;

}