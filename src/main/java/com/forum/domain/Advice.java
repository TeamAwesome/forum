package com.forum.domain;

import java.util.Date;

public class Advice {
    private int questionId;
    private Date createdAt;
    private User user;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advice advice = (Advice) o;

        if (questionId != advice.questionId) return false;
        if (createdAt != null ? !createdAt.equals(advice.createdAt) : advice.createdAt != null) return false;
        if (description != null ? !description.equals(advice.description) : advice.description != null) return false;
        if (user != null ? !user.equals(advice.user) : advice.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Advice(int questionId, User user, String description) {
        this.questionId = questionId;
        this.createdAt = createdAt;
        this.user = user;
        this.description = description;

    }
}
