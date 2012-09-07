package com.forum.domain;

import com.forum.service.validation.NoHTMLScript;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class Question implements Serializable {
    private  static Logger logger = Logger.getLogger(Question.class.getName());
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
    private String tagsAsString;

    private List<Advice> advices;

    public Question() {
    }

    public Question(int id, String title, String description, User user, Date createdAt) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.createdAt = createdAt;
        this.description = description;

        logger.info("a question an ID has been created");
    }

    public Question(String title, String description, User user, Date createdAt) {
        this.title = title;
        this.user = user;
        this.createdAt = createdAt;
        this.description = description;

        logger.info("a question without an id has been created");
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

        logger.info("a question with stats has been created");
    }

    public Question(int id, String title, String description, User user, Date createdAt, int likes, int disLikes, int flags , String tagsAsString) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.createdAt = createdAt;
        this.description = description;
        this.likes = likes;
        this.dislikes = disLikes;
        this.flags = flags;
        this.tagsAsString = tagsAsString;
        logger.info("a question with stats and tags has been created");
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

    public List<Tag> getTags() {
        List<Tag> result = new ArrayList<Tag>();

        if (tagsAsString != null) {
            String[] tagArray = tagsAsString.split(",");
            for (String tag : tagArray){
                result.add(new Tag(tag.trim()));
            }
        }

        return result;
    }

    public String getTagsAsString() {
        return tagsAsString;
    }

    public void setTagsAsString(String tagsAsString) {
        this.tagsAsString = tagsAsString;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", flags=" + flags +
                ", views=" + views +
                ", tagsAsString='" + tagsAsString + '\'' +
                ", advices=" + advices +
                '}';
    }
}

