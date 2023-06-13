package ru.otus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.model.Test;
import ru.otus.service.*;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        ReadService readService = context.getBean(ReadServiceImpl.class);
        LoadService loadService = context.getBean(LoadServiceImpl.class);
        LauncherService launcherService = context.getBean(LauncherServiceImpl.class);
        Test test = loadService.load(readService.read());
        launcherService.launch(test);
        context.close();
    }
}