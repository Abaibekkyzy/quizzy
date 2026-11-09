package org.example.quizzy.repository;

import jakarta.transaction.Transactional;
import org.example.quizzy.model.Question;
import org.example.quizzy.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByQuizId(Long quizId);
}
