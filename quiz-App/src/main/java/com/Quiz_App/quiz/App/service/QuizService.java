package com.Quiz_App.quiz.App.service;

import com.Quiz_App.quiz.App.dto.*;
import com.Quiz_App.quiz.App.enums.Difficulty;
import com.Quiz_App.quiz.App.exception.ResourceNotFoundException;
import com.Quiz_App.quiz.App.model.Question;
import com.Quiz_App.quiz.App.model.QuizSession;
import com.Quiz_App.quiz.App.model.User;
import com.Quiz_App.quiz.App.repository.QuestionRepository;
import com.Quiz_App.quiz.App.repository.QuizSessionRepository;
import com.Quiz_App.quiz.App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {

    private final static int QUESTION_LIMIT=20;

    @Autowired
    private QuizSessionRepository sessionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    // Start a new quiz session
    public QuizSessionResponseDTO startQuizSession(SessionRequestDTO request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        QuizSession session = new QuizSession();
        session.setUser(user);
        session.setDifficulty(request.getDifficulty());
        session.setQuestionCount(request.getQuestionCount());
        sessionRepository.save(session);

        return new QuizSessionResponseDTO(session.getId(), session.getDifficulty(), session.getQuestionCount());
    }

    public List<QuestionResponseDTO> getRandomQuestions(Long sessionId) {
        QuizSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("Session not found"));

        int numberOfQuestions = session.getQuestionCount();

        if (numberOfQuestions > QUESTION_LIMIT) {
            throw new IllegalArgumentException("Number of questions in a session cannot exceed " + QUESTION_LIMIT);
        }

        Difficulty difficulty=session.getDifficulty();

        // Create a Pageable instance to limit the number of questions fetched
        Pageable pageable = PageRequest.of(0, numberOfQuestions);

        // Retrieve random questions based on the difficulty level
        List<Question> randomQuestions = questionRepository.findRandomQuestionsByDifficulty(difficulty, pageable);

        List<QuestionResponseDTO> questionResponseDTOs = new ArrayList<>();
        for (Question question : randomQuestions) {
            questionResponseDTOs.add(new QuestionResponseDTO(
                    question.getId(),
                    question.getText(),
                    question.getOptionA(),
                    question.getOptionB(),
                    question.getOptionC(),
                    question.getOptionD()
            ));
        }

        return questionResponseDTOs;
    }




    // Submit answers for a session
    public AnswerResponseDTO submitAnswers(SubmitAnswerDTO submitAnswerDTO) {

        QuizSession session = sessionRepository.findById(submitAnswerDTO.getSessionId())
                .orElseThrow(() -> new ResourceNotFoundException("Session not found"));

        int correctAnswers = 0;
        int notAttempted = 0;

        for (Map.Entry<Long, String> entry : submitAnswerDTO.getAnswers().entrySet()) {
            Long questionId = entry.getKey();
            String userAnswer = entry.getValue();

            Question question = questionRepository.findById(questionId)
                    .orElseThrow(() -> new ResourceNotFoundException("Question not found"));

            if (userAnswer == null || userAnswer.isBlank()) {
                notAttempted++;
            } else if (userAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
                correctAnswers++;
            }
        }

        session.setCorrectAnswers(correctAnswers);
        session.setNotAttempted(notAttempted);
        sessionRepository.save(session);

        return new AnswerResponseDTO(correctAnswers, notAttempted);
    }

    // Get quiz summary for the user
    public QuizSummaryDTO getQuizSummary(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        QuizSession session = sessionRepository.findTopByUserOrderByCreatedAtDesc(user)
                .orElseThrow(() -> new ResourceNotFoundException("No session found for the user"));

        int totalQuestions = session.getQuestionCount();
        int correctAnswers = session.getCorrectAnswers();
        int notAttempted = session.getNotAttempted();
        int score = (int) ((correctAnswers / (double) totalQuestions) * 100);

        String remark = score >= 80 ? "Excellent" : score >= 50 ? "Good" : "Needs Improvement";

        return new QuizSummaryDTO(session.getId(), totalQuestions, correctAnswers, notAttempted, score, remark);
    }
}

