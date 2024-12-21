package com.Quiz_App.quiz.App.controller;


import com.Quiz_App.quiz.App.dto.*;
import com.Quiz_App.quiz.App.service.QuizService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public ResponseEntity<QuizSessionResponseDTO> startQuizSession(@Valid @RequestBody SessionRequestDTO request) {
        return ResponseEntity.ok(quizService.startQuizSession(request));
    }

    @GetMapping("/questions")
    public ResponseEntity<List<QuestionResponseDTO>> getRandomQuestions(@RequestParam @NotNull Long sessionId) {
        List<QuestionResponseDTO> questions = quizService.getRandomQuestions(sessionId);
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/submit")
    public ResponseEntity<AnswerResponseDTO> submitQuiz(@Valid @RequestBody SubmitAnswerDTO submitAnswerDTO) {

        AnswerResponseDTO response = quizService.submitAnswers(submitAnswerDTO);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/summary")
    public ResponseEntity<QuizSummaryDTO> getQuizSummary(@RequestParam @NotNull Long userId) {
        QuizSummaryDTO summary = quizService.getQuizSummary(userId);
        return ResponseEntity.ok(summary);
    }
}