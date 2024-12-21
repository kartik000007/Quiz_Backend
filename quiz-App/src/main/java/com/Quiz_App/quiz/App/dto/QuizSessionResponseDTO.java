package com.Quiz_App.quiz.App.dto;

import com.Quiz_App.quiz.App.enums.Difficulty;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuizSessionResponseDTO {

    private Long sessionId;
    private Difficulty difficulty;
    private int questionCount;

}
