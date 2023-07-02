package ru.otus.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({TestProperties.class})
public class ApplicationConfiguration {
}
