package ru.otus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.service.LauncherService;

@ComponentScan
@Configuration
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        LauncherService launcherService = context.getBean(LauncherService.class);
        launcherService.launch();
    }
}