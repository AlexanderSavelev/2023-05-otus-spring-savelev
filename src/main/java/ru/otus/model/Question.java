package ru.otus.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Question {
    private int id;
    private String text;
    private List<Answer> answers;
}
