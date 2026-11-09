package org.example.quizzy.api;

import lombok.RequiredArgsConstructor;
import org.example.quizzy.model.Quiz;
import org.example.quizzy.service.QuizService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/quiz")
public class QuizController {

    private final QuizService quizService;

    @GetMapping(value="/get-quiz-list")
    public List<Quiz> getQuizList(){
        return quizService.getQuizes();
    }
}
