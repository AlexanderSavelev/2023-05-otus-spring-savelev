package ru.otus.service;

import org.springframework.stereotype.Service;
import ru.otus.dao.TestDao;
import ru.otus.model.Question;
import ru.otus.model.Result;
import ru.otus.model.Test;
import ru.otus.model.User;

@Service
public class LauncherServiceImpl implements LauncherService {

    private final TestDao testDao;

    private final IOService ioService;

    private final LocaleService localeService;

    public LauncherServiceImpl(TestDao testDao,
                               IOService ioService,
                               LocaleService localeService) {
        this.testDao = testDao;
        this.ioService = ioService;
        this.localeService = localeService;
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
        ioService.output(localeService.askFirstName());
        String firstName = ioService.input();
        ioService.output(localeService.askLastName());
        String lastName = ioService.input();
        return new User(firstName, lastName);
    }

    private void startTest() {
        ioService.outputEmptyLine();
        ioService.output(localeService.getStartMessage());
        ioService.input();
    }

    private void getAnswer(Result result, Question question) {
        ioService.output(localeService.getChooseQuestionMessage());
        result.applyAnswer(question.getId(), ioService.input());
        ioService.outputEmptyLine();
    }

    private void printResult(User user, Test test, Result result) {
        ioService.output(localeService.getTestResult(result, user));
        ioService.output(result.getResults() >= test.getPassPercentage() ?
                localeService.getTestPassedMessage() :
                localeService.getTestNotPassedQuestion());
    }
}
