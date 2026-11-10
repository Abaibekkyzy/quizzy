package org.example.quizzy.api;


import lombok.RequiredArgsConstructor;
import org.example.quizzy.model.AnswerOption;
import org.example.quizzy.service.AnswerOptionService;
import org.example.quizzy.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions/{questionId}/answers")
@RequiredArgsConstructor
public class AnswerOptionRestController {

    private final AnswerOptionService answerOptionService;
    private final QuestionService questionService;

    @PostMapping
    public AnswerOption addAnswerOption(@PathVariable Long questionId,
                                        @RequestBody AnswerOption answerOption) {
        answerOption.setQuestion(questionService.getQuestion(questionId));

        return answerOptionService.addAnswerOption(answerOption);
    }

    @GetMapping
    public List<AnswerOption> getAnswers(@PathVariable Long questionId) {
        return answerOptionService.getAnswers(questionId);
    }

}
