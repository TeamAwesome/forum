package com.forum.test.builder;

import com.forum.domain.Question;
import com.forum.domain.User;

import java.util.Date;

public class QuestionBuilder {

    private String title;
    private String description;
    private User user;
    private Date createdAt;
    private int likes;
    private int dislikes;
    private int flags;
    private String tagsAsString;

    private QuestionBuilder() {

    }

    public Question build() {
        return new Question(0, title, description, user, createdAt, likes, dislikes, flags, tagsAsString);
    }

    public QuestionBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public QuestionBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public static QuestionBuilder givenAQuestion() {
        return new QuestionBuilder();
    }
}
