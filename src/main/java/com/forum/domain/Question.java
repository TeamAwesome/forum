package com.forum.domain;

import java.io.Serializable;
import java.util.Date;

public class Question implements Serializable {
    private int id;
    private String title;
    private Date createdAt;
    private String description;
    private User user;
    private int likes;
    private int dislikes;
    private int flags;
    private int views;

    public Question(int id, String title,String description, User user, Date createdAt){
        this.id = id;
        this.title=title;
        this.user= user;
        this.createdAt = createdAt;
        this.description=description;
    }

    public Question(String title,String description, User user, Date createdAt){
        this.title=title;
        this.user= user;
        this.createdAt = createdAt;
        this.description=description;
    }

    public Question(int id, String title, String description, User user, Date createdAt, int likes, int disLikes, int flags) {
        this.id = id;
        this.title=title;
        this.user= user;
        this.createdAt = createdAt;
        this.description=description;
        this.likes = likes;
        this.dislikes = disLikes;
        this.flags = flags;
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
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public int getViews() {
        return views;
    }

    public int getFlags() {
        return flags;
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

    public int getResponses() {
        return 0;
    }

}
