package ru.otus.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestTest {

    private List<Question> questions;

    private ru.otus.model.Test test;

    @BeforeEach
    void setUp() {
        Question firstQuestion = new Question(1, "question_0",
                List.of(new Answer("A", "answer_0"), new Answer("B", "answer_1")));
        Question secondQuestion = new Question(2, "question_1",
                List.of(new Answer("C", "answer_2"), new Answer("D", "answer_3")));
        questions = List.of(firstQuestion, secondQuestion);
        test = new ru.otus.model.Test(questions);
    }

    @Test
    void getQuestions() {
        assertEquals(questions, test.getQuestions());
    }

    @Test
    void setQuestions() {
        Question thirdQuestion = new Question(3, "question_2",
                List.of(new Answer("E", "answer_4"), new Answer("F", "answer_5")));
        Question fourthQuestion = new Question(4, "question_3",
                List.of(new Answer("G", "answer_6"), new Answer("H", "answer_7")));
        List<Question> newQuestions = List.of(thirdQuestion, fourthQuestion);
        test.setQuestions(newQuestions);
        assertEquals(newQuestions, test.getQuestions());
    }

    @Test
    void builder() {
        ru.otus.model.Test newTest = ru.otus.model.Test.builder()
                .questions(questions)
                .build();
        assertEquals(test, newTest);
    }
}