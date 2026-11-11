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

    @GetMapping("play/quiz/{d}")
    public String showQuiz(@PathVariable Long d, Model model){
        var Quiz = quizService.getQuiz(d);

        List<Question> questions = questionService.findByQuizId(Quiz.getId());

        Map<Long, List<AnswerOption>> answersByQuestionId = new HashMap<>();

        for(Question question : questions){

            List<AnswerOption> answers = answerOptionService.getAnswers(question.getId());
            answersByQuestionId.put(question.getId(), answers);
        }

        model.addAttribute("quiz", Quiz);
        model.addAttribute("questions", questions);
        model.addAttribute("answersByQuestionId", answersByQuestionId);
        return "quizPage";
    }
}
