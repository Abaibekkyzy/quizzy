package org.example.quizzy.repository;

import jakarta.transaction.Transactional;
import org.example.quizzy.model.AnswerOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AnswerOptionRepository extends JpaRepository<AnswerOption, Long> {
}
