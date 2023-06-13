package ru.otus.service;

import ru.otus.model.Test;

import java.io.InputStream;

public interface LoadService {
    Test load(InputStream stream);
}
