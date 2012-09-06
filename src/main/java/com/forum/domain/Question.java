package com.forum.domain;

import com.forum.service.validation.NoHTMLScript;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Serializable {
    private int id;

    @NotBlank(message = "Title is empty.")
    @NoHTMLScript
    private String title;

    @NotBlank(message = "Description is empty.")
    private String description;

    private Date createdAt;

    private User user;

    private int likes;
    private int dislikes;
    private int flags;

    private int views;

    private List<Advice> advices;
    public Question() {
    }

    private List<Tag> tags;

    public Question(int id, String title, String description, User user, Date createdAt) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.createdAt = createdAt;
        this.description = description;
        tags = new ArrayList<Tag>();
    }

    public Question(String title, String description, User user, Date createdAt) {
        this.title = title;
        this.user = user;
        this.createdAt = createdAt;
        this.description = description;
        tags = new ArrayList<Tag>();
    }

    public Question(int id, String title, String description, User user, Date createdAt, int likes, int disLikes, int flags) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.createdAt = createdAt;
        this.description = description;
        this.likes = likes;
        this.dislikes = disLikes;
        this.flags = flags;
        tags = new ArrayList<Tag>();
    }

    public Question(int id, String title, String description, User user, Date createdAt, int likes, int disLikes, int flags , List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.createdAt = createdAt;
        this.description = description;
        this.likes = likes;
        this.dislikes = disLikes;
        this.flags = flags;
        this.tags = tags;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setAdvices(List<Advice> advices) {
        this.advices = advices;
    }

    public List<Advice> getAdvices() {
        return advices;
    }
}
