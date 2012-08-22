package com.forum.domain;

public class Question {
    private String title;

    private String description;

    public Question(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
