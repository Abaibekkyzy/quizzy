package org.example.quizzy.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_answer_options")
@Getter
@Setter
public class AnswerOption extends BaseModel {

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;
}
