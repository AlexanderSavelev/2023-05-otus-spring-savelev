package ru.otus.service;

import ru.otus.model.Result;
import ru.otus.model.User;

public interface LocaleService {

    String askFirstName();

    String askLastName();

    String getStartMessage();

    String getChooseQuestionMessage();

    String getTestResult(Result result, User user);

    String getTestPassedMessage();

    String getTestNotPassedQuestion();
}
