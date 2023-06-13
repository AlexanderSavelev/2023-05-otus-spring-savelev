package ru.otus.service;

import ru.otus.model.Answer;
import ru.otus.model.Question;
import ru.otus.model.Test;

import java.util.List;

public class LauncherServiceImpl implements LauncherService {
    @Override
    public void launch(Test test) {
        List<Question> questions = test.getQuestions();
        for (Question question : questions) {
            System.out.println(question.getId() + ". " + question.getText());
            for (Answer answer : question.getAnswers()) {
                System.out.println(answer.getId() + " " + answer.getText());
            }
        }
    }
}
