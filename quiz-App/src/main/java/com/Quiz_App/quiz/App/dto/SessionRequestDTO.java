package com.Quiz_App.quiz.App.dto;

import com.Quiz_App.quiz.App.enums.Difficulty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SessionRequestDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Difficulty difficulty;

    @NotNull
    @Min(1)
    @Max(10)
    private int questionCount;

}
