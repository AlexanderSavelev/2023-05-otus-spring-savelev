package ru.otus.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.config.LocaleProperties;
import ru.otus.config.TestApplicationConfiguration;
import ru.otus.model.Result;
import ru.otus.model.User;

@Service
public class LocaleServiceImpl implements LocaleService {

    private final MessageSource messageSource;

    private final LocaleProperties localeProperties;

    public LocaleServiceImpl(MessageSource messageSource, TestApplicationConfiguration testApplicationConfiguration) {
        this.messageSource = messageSource;
        this.localeProperties = testApplicationConfiguration;
    }

    @Override
    public String askFirstName() {
        return messageSource.getMessage("user.first.name", null, localeProperties.getLocale());
    }

    @Override
    public String askLastName() {
        return messageSource.getMessage("user.last.name", null, localeProperties.getLocale());
    }

    @Override
    public String getStartMessage() {
        return messageSource.getMessage("press.any.key", null, localeProperties.getLocale());
    }

    @Override
    public String getChooseQuestionMessage() {
        return messageSource.getMessage("choose.answer", null, localeProperties.getLocale());
    }

    @Override
    public String getTestResult(Result result, User user) {
        return messageSource.getMessage("test.result", new String[]{user.toString(),
                String.valueOf(result.getResults())}, localeProperties.getLocale());
    }

    @Override
    public String getTestPassedMessage() {
        return messageSource.getMessage("test.passed", null, localeProperties.getLocale());
    }

    @Override
    public String getTestNotPassedQuestion() {
        return messageSource.getMessage("test.not.passed", null, localeProperties.getLocale());
    }
}
