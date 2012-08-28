package com.forum.domain;

import java.io.Serializable;
import java.util.Date;

public class Question implements Serializable {
    private int id;
    private String title;
    private Date createdAt;
    private String description;
    private User user;

    public Question(int id, String title,String description, User user, Date createdAt){
        this.id = id;
        this.title=title;
        this.user= user;
        this.createdAt = createdAt;
        this.description=description;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreatedAt() {
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

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createdAt=" + createdAt.toString() +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }

    public int getId() {
        return id;
    }
}
