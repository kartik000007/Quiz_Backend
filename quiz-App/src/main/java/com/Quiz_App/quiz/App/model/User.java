package com.Quiz_App.quiz.App.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotBlank
    @Column(name = "user_name", nullable = false)
    private String name;

    public User(String name) {
        this.name = name;
    }

    public User() {}
}
