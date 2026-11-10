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

}
