package com.forum.domain;

public class Question {
    private String title;
    private String dateTime;
    private String description;
    private String user;

    public  Question(String title,String description,String user,String dateTime ){
        this.title=title;
        this.user=user;
        this.dateTime=dateTime;
        this.description=description;
    }

    public String getTitle() {
        return title;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public String getUser() {
        return user;
    }
}
