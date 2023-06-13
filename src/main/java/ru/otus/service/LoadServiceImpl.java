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

    private final String separator;

    public LoadServiceImpl(String separator) {
        this.separator = separator;
    }

    @Override
    public Test load(InputStream stream) {
        List<Question> questions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            int j = 1;
            while ((line = reader.readLine()) != null) {
                Question question = Question.builder()
                        .id(j)
                        .text(loadText(line))
                        .answers(loadAnswers(line))
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

    @Override
    public String loadText(String line) {
        String[] array = line.split(separator);
        return array[0];
    }

    @Override
    public List<Answer> loadAnswers(String line) {
        String[] array = line.split(separator);
        List<Answer> answerList = new ArrayList<>();
        for (int i = 1; i < array.length; i++) {
            answerList.add(Answer.builder()
                    .id(String.valueOf((char) (64 + i)))
                    .text(array[i])
                    .build());
        }
        return answerList;
    }
}
