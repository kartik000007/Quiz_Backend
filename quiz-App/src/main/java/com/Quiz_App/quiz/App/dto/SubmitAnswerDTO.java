package com.Quiz_App.quiz.App.dto;

import java.util.List;
import java.util.Map;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubmitAnswerDTO {

    @NotNull
    private Long sessionId;

    @NotNull
    private Map<Long, String> answers;

}