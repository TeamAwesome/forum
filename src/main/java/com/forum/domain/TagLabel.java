package com.forum.domain;

public class TagLabel {
    private int id;
    private  String value;
    private  int count;


    public TagLabel(int id, String value, int count) {
        this.id=id;
        this.value = value.toLowerCase();
        this.count=count;

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
