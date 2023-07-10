package ru.otus.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.config.LocaleProperties;
import ru.otus.config.TestApplicationConfiguration;
import ru.otus.dao.TestDao;
import ru.otus.model.Question;
import ru.otus.model.Result;
import ru.otus.model.Test;
import ru.otus.model.User;

@Service
public class LauncherServiceImpl implements LauncherService {

    private final TestDao testDao;

    private final IOService ioService;

    private final MessageSource messageSource;

    private final LocaleProperties localeProperties;

    public LauncherServiceImpl(TestDao testDao,
                               IOService ioService,
                               MessageSource messageSource,
                               TestApplicationConfiguration testApplicationConfiguration) {
        this.testDao = testDao;
        this.ioService = ioService;
        this.messageSource = messageSource;
        this.localeProperties = testApplicationConfiguration;
    }

    @Override
    public void launch() {
        User user = getUser();
        Test test = testDao.load();
        startTest();
        Result result = new Result(test, user);
        while (test.hasNextQuestion()) {
            Question question = test.getNextQuestion();
            ioService.output(question.toString());
            while (question.hasNextAnswer()) {
                ioService.output(question.getNextAnswer().toString());
            }
            getAnswer(result, question);
        }
        printResult(user, test, result);
    }

    private User getUser() {
        ioService.output(messageSource.getMessage("user.first.name", null, localeProperties.getLocale()));
        String firstName = ioService.input();
        ioService.output(messageSource.getMessage("user.last.name", null, localeProperties.getLocale()));
        String lastName = ioService.input();
        return new User(firstName, lastName);
    }

    private void startTest() {
        ioService.outputEmptyLine();
        ioService.output(messageSource.getMessage("press.any.key", null, localeProperties.getLocale()));
        ioService.input();
    }

    private void getAnswer(Result result, Question question) {
        ioService.output(messageSource.getMessage("choose.answer", null, localeProperties.getLocale()));
        result.applyAnswer(question.getId(), ioService.input());
        ioService.outputEmptyLine();
    }

    private void printResult(User user, Test test, Result result) {
        ioService.output(messageSource.getMessage("test.result", new String[]{user.toString(),
                String.valueOf(result.getResults())}, localeProperties.getLocale()));
        ioService.output(result.getResults() >= test.getPassPercentage() ?
                messageSource.getMessage("test.passed", null, localeProperties.getLocale()) :
                messageSource.getMessage("test.not.passed", null, localeProperties.getLocale()));
    }
}
