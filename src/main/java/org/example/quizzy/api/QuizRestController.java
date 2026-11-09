package org.example.quizzy.api;

import lombok.RequiredArgsConstructor;
import org.example.quizzy.model.Quiz;
import org.example.quizzy.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/quiz")
@RequiredArgsConstructor
public class QuizRestController {
    private final QuizService quizService;

    @GetMapping
    public List<Quiz> getQuizList(){
        return quizService.getQuizzes();
    }

    @GetMapping("{id}")
    public Quiz getQuiz(@PathVariable Long id){
        return quizService.getQuiz(id);
    }

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }
}
