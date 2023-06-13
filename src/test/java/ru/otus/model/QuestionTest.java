package ru.otus.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionTest {

    private Question question;

    private final int id = 0;

    private final String text = "question";

    private final List<Answer> answers = List.of(new Answer("A", "answer_0"), new Answer("B", "answer_1"));

    @BeforeEach
    void setUp() {
        question = new Question(id, text, answers);
    }

    @Test
    void getId() {
        assertEquals(id, question.getId());
    }

    @Test
    void getText() {
        assertEquals(text, question.getText());
    }

    @Test
    void getAnswers() {
        assertEquals(answers, question.getAnswers());
    }

    @Test
    void setId() {
        int newId = 1;
        question.setId(newId);
        assertEquals(newId, question.getId());
    }

    @Test
    void setText() {
        String newText = "new question";
        question.setText(newText);
        assertEquals(newText, question.getText());
    }

    @Test
    void setAnswers() {
        List<Answer> newAnswers = List.of(new Answer("C", "answer_2"), new Answer("D", "answer_3"));
        question.setAnswers(newAnswers);
        assertEquals(newAnswers, question.getAnswers());
    }

    @Test
    void builder() {
        Question newQuestion = Question.builder()
                .id(id)
                .text(text)
                .answers(answers)
                .build();
        assertEquals(question, newQuestion);
    }
}