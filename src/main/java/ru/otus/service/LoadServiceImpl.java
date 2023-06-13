package ru.otus.service;

import ru.otus.model.Answer;
import ru.otus.model.Question;
import ru.otus.model.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LoadServiceImpl implements LoadService {

    private final String SEPARATOR = ",";

    @Override
    public Test load(InputStream stream) {
        List<Question> questions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            int j = 0;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(SEPARATOR);
                List<Answer> answerList = new ArrayList<>();
                for (int i = 1; i < array.length; i++) {
                    answerList.add(Answer.builder()
                                    .id(String.valueOf((char) (64 + i)))
                                    .text(array[i])
                            .build());
                }
                Question question = Question.builder()
                        .id(j)
                        .text(array[0])
                        .answers(answerList)
                        .build();
                questions.add(question);
                j++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Test.builder()
                .questions(questions)
                .build();
    }
}
