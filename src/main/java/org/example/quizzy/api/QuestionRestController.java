package org.example.quizzy.api;

import lombok.RequiredArgsConstructor;
import org.example.quizzy.model.Question;
import org.example.quizzy.service.QuestionService;
import org.example.quizzy.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz/{quizId}/questions")
@RequiredArgsConstructor
public class QuestionRestController {
    private final QuizService quizService;
    private final QuestionService questionService;

    @PostMapping
    public Question addQuestion(@PathVariable Long quizId,
                                @RequestBody Question question){
        question.setQuiz(quizService.getQuiz(quizId));

        return questionService.addQuestion(question);
    }

    @GetMapping
    public List<Question> findByQuizId(@PathVariable Long quizId){
        return questionService.findByQuizId(quizId);
    }
}
