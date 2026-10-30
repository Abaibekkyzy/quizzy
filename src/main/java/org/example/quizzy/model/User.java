package org.example.quizzy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_users")
@Getter
@Setter

public class User extends BaseModel{

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name ="username", nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;
}
