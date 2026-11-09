package org.example.quizzy.service;
import lombok.RequiredArgsConstructor;
import org.example.quizzy.model.Quiz;
import org.example.quizzy.repository.QuizRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    public List<Quiz> getQuizes(){
        return quizRepository.findAll();
    }

    public Quiz getQuiz(Long id){
        return quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found with id: " + id));
    }

    public Quiz addQuiz(Quiz quiz){
        return quizRepository.save(quiz);
    }
}
