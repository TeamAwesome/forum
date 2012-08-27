package com.forum.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Question implements Serializable {
    private int id;
    private String title;
    private Timestamp createdAt;
    private String description;
    private User user;

    public Question(int id, String title,String description, User user, Timestamp createdAt){
        this.id = id;
        this.title=title;
        this.user= user;
        this.createdAt = createdAt;
        this.description=description;
    }

    public String getTitle() {
        return title;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public int getLikes() {
        return 0;
    }

    public int getDislikes() {
        return 0;
    }

    public int getViews() {
        return 0;
    }

    public int getFlags() {
        return 0;
    }

    public int getId() {
        return id;
    }
}
