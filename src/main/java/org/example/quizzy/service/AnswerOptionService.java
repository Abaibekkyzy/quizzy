package org.example.quizzy.service;

import lombok.RequiredArgsConstructor;
import org.example.quizzy.model.AnswerOption;
import org.example.quizzy.repository.AnswerOptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerOptionService {

    private final AnswerOptionRepository answerOptionRepository;

    public AnswerOption addAnswerOption(AnswerOption answerOption) {
        return answerOptionRepository.save(answerOption);
    }

    public List<AnswerOption> getAnswers(Long questionId) {
        return answerOptionRepository.findAllByQuestionId(questionId);
    }

    public AnswerOption getAnswer(Long id){
        return answerOptionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(   "Answer not found with id: " + id));
    }

    public boolean checkAnswer(Long id){
        AnswerOption answerOption = getAnswer(id);
        return answerOption.isCorrect();
    }

}
