package ru.otus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.util.Locale;

@ConfigurationProperties(prefix = "test")
public class TestProperties {

    private final String separator;

    private final String name;

    private final int pass;

    private final Locale locale;

    @ConstructorBinding
    public TestProperties(String separator, String name, int pass, Locale locale) {
        this.separator = separator;
        this.name = name;
        this.pass = pass;
        this.locale = locale;
    }

    public String getSeparator() {
        return separator;
    }

    public String getName() {
        return name;
    }

    public int getPass() {
        return pass;
    }

    public Locale getLocale() {
        return locale;
    }
}
