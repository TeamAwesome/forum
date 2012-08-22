package com.forum.domain;

public class Question1 {
    private String title;
    private String date;
    private String time;
    private String description;
    private String user;

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getUser() {
        return user;
    }
}
