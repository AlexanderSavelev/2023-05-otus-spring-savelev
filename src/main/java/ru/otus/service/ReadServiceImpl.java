package ru.otus.service;

import java.io.InputStream;

public class ReadServiceImpl implements ReadService {

    private final String file;

    public ReadServiceImpl(String file) {
        this.file = file;
    }

    @Override
    public InputStream read() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return classloader.getResourceAsStream(file);
    }
}
