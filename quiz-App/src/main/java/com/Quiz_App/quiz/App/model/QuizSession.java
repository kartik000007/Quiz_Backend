package com.Quiz_App.quiz.App.model;

import com.Quiz_App.quiz.App.enums.Difficulty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quiz_session")
@Entity
public class QuizSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "correct_answers", nullable = false)
    private int correctAnswers;

    @Column(name = "not_attempted", nullable = false)
    private int notAttempted;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_level", nullable = false)
    private Difficulty difficulty;

    @Column(name = "question_count", nullable = false)
    private int questionCount;

    @ManyToMany
    @JoinTable(
            name = "quiz_session_questions",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt = new Date();
}

