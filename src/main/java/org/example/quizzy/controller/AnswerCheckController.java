package org.example.quizzy.controller;

import lombok.RequiredArgsConstructor;
import org.example.quizzy.service.AnswerOptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/answers")
@RequiredArgsConstructor
public class AnswerCheckController {
    private final AnswerOptionService answerOptionService;

    @GetMapping("/{id}/check")
    public Map<String, Boolean> checkAnswer(@PathVariable Long id) {

        boolean correct = answerOptionService.checkAnswer(id);

        return Map.of("correct", correct);
    }

}
