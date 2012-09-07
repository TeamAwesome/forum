package com.forum.domain;

import javax.validation.constraints.Pattern;

public class Tag {
    private int id;
    public static final String REGEXP = "a-zA-Z0-9äöüÄÖÜß ";

    @Pattern(regexp = "^[" + REGEXP + "]*$")
    private String value;

    private int count;

    public Tag(int id, String value, int count) {
        this.id = id;
        this.value = value.toLowerCase();
        this.count = count;

    }

    public Tag(String value) {
        this.value = value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        if (count != tag.count) return false;
        if (id != tag.id) return false;
        if (value != null ? !value.equals(tag.value) : tag.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", count=" + count +
                '}';
    }
}
