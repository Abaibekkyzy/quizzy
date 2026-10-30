package org.example.quizzy.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="t_question")
@Getter
@Setter
public class Question extends BaseModel{

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "points")
    private int points;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
