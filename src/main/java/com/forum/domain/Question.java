package com.forum.domain;

import java.io.Serializable;

public class Question implements Serializable {
    private int id;
    private String title;
    private String createdAt;
    private String description;
    private int userId;

    public Question(int id, String title,String description,int userId,String createdAt){
        this.id = id;
        this.title=title;
        this.userId=userId;
        this.createdAt = createdAt;
        this.description=description;
    }

    public String getTitle() {
        return title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public int getUserId() {
        return userId;
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
