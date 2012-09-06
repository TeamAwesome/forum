package com.forum.domain;

public class Tag {
    private int id;
    private String value;
    private int count;

    public Tag(int id, String value, int count) {
        this.id = id;
        this.value = value.toLowerCase();
        this.count = count;

    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }
}
