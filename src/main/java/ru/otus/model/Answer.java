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

    public Answer(String id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Answer other = (Answer) obj;
        if (!this.id.equals(other.id)) {
            return false;
        }
        if (!this.text.equals(other.text)) {
            return false;
        }
        return true;
    }
}
