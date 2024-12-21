package com.Quiz_App.quiz.App.repository;

import com.Quiz_App.quiz.App.enums.Difficulty;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.Quiz_App.quiz.App.model.Question;
import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByDifficulty(Difficulty difficulty);


    @Query("SELECT q FROM Question q WHERE q.difficulty = :difficulty ORDER BY RAND()")
    List<Question> findRandomQuestionsByDifficulty(@Param("difficulty") Difficulty difficulty, Pageable pageable);

}
