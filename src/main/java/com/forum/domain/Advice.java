package com.forum.domain;

import java.util.Date;

public class Advice {
    private int questionId;
    private Date createdAt;
    private String username;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advice advice = (Advice) o;

        if (questionId != advice.questionId) return false;
        if (createdAt != null ? !createdAt.equals(advice.createdAt) : advice.createdAt != null) return false;
        if (description != null ? !description.equals(advice.description) : advice.description != null) return false;
        if (username != null ? !username.equals(advice.username) : advice.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Advice(int questionId, String username, String description) {
        this.questionId = questionId;
        this.createdAt = createdAt;
        this.username = username;
        this.description = description;

    }
}
