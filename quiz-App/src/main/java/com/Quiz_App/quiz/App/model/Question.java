package com.Quiz_App.quiz.App.model;

import com.Quiz_App.quiz.App.enums.Difficulty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @NotBlank
    @Column(name = "question_text", nullable = false)
    private String text;

    @Column(name = "option_a", nullable = false)
    private String optionA;

    @Column(name = "option_b", nullable = false)
    private String optionB;

    @Column(name = "option_c", nullable = false)
    private String optionC;

    @Column(name = "option_d", nullable = false)
    private String optionD;

    @NotBlank
    @Column(name = "correct_answer", nullable = false)
    private String correctAnswer;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_level", nullable = false)
    private Difficulty difficulty;

    public Question(String s, String answer, Difficulty difficulty, String number1, String number2, String number3, String number4) {
        this.text=s;
        this.correctAnswer=answer;
        this.difficulty=difficulty;
        this.optionA=number1;
        this.optionB=number2;
        this.optionC=number3;
        this.optionD=number4;
    }

    public Question(){}
}