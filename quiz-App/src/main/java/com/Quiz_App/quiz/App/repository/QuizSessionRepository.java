package com.Quiz_App.quiz.App.repository;

import com.Quiz_App.quiz.App.model.QuizSession;
import com.Quiz_App.quiz.App.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizSessionRepository extends JpaRepository<QuizSession,Long> {
    Optional<QuizSession> findTopByUserOrderByCreatedAtDesc(User user);
}
