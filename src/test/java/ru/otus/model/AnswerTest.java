package ru.otus.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerTest {

    private Answer answer;

    private final String id = "A";

    private final String text = "answer";

    @BeforeEach
    void setUp() {
        answer = new Answer(id, text);
    }

    @Test
    void getId() {
        assertEquals(id, answer.getId());
    }

    @Test
    void getText() {
        assertEquals(text, answer.getText());
    }

    @Test
    void setId() {
        String newId = "B";
        answer.setId(newId);
        assertEquals(newId, answer.getId());
    }

    @Test
    void setText() {
        String newText = "new answer";
        answer.setText(newText);
        assertEquals(newText, answer.getText());
    }

    @Test
    void builder() {
        Answer newAnswer = Answer.builder()
                .id(id)
                .text(text)
                .build();
        assertEquals(answer, newAnswer);
    }
}