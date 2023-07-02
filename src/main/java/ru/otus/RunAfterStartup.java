package ru.otus;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.otus.service.LauncherService;

@Component
public class RunAfterStartup {

    private final LauncherService launcherService;

    public RunAfterStartup(LauncherService launcherService) {
        this.launcherService = launcherService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        launcherService.launch();
    }
}
