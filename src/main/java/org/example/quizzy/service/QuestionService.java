package org.example.quizzy.service;

import lombok.RequiredArgsConstructor;
import org.example.quizzy.model.Question;
import org.example.quizzy.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question addQuestion(Question question){
        return questionRepository.save(question);
    }

    public List<Question> findByQuizId(Long quizId){
        return questionRepository.findByQuizId(quizId);
    }
}
