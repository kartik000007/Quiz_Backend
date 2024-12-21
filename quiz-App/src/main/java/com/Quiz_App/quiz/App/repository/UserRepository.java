package com.Quiz_App.quiz.App.repository;

import com.Quiz_App.quiz.App.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
