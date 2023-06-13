package ru.otus.service;

import ru.otus.model.Answer;
import ru.otus.model.Test;

import java.io.InputStream;
import java.util.List;

public interface LoadService {

    Test load(InputStream stream);

    String loadText(String line);

    List<Answer> loadAnswers(String line);
}
