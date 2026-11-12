package org.example.quizzy.controller;

import lombok.RequiredArgsConstructor;
import org.example.quizzy.model.AnswerOption;
import org.example.quizzy.model.Question;
import org.example.quizzy.service.AnswerOptionService;
import org.example.quizzy.service.QuestionService;
import org.example.quizzy.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class QuizPageController {
    private final QuizService quizService;
    private final AnswerOptionService answerOptionService;
    private final QuestionService questionService;

    @GetMapping("/play/quiz/{id}")
    public String showQuiz(@PathVariable Long id, Model model){
        var quiz = quizService.getQuiz(id);

        List<Question> questions = questionService.findByQuizId(quiz.getId());

        Map<Long, List<AnswerOption>> answersByQuestionId = new HashMap<>();

        for(Question question : questions){

            List<AnswerOption> answers = answerOptionService.getAnswers(question.getId());
            answersByQuestionId.put(question.getId(), answers);
        }

        model.addAttribute("quiz", quiz);
        model.addAttribute("questions", questions);
        model.addAttribute("answersByQuestionId", answersByQuestionId);
        return "quizPage";
    }
}
