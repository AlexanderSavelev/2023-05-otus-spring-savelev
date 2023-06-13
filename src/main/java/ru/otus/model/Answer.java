package ru.otus.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Answer {
    private String id;
    private String text;
}
