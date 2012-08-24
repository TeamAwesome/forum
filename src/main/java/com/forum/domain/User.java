package com.forum.domain;


import java.util.List;

public class User {
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String country;
    private String gender;
    private int age;
    private List<String> interests;
    private List<String> knowledge;
    private Boolean privacy;
    private String username;

    public User(String username, String password, String name, String email, String phoneNumber,
                String country, String gender, int age) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.gender = gender;
        this.age = age;
        this.interests = interests;
        this.knowledge = knowledge;
        this.privacy = privacy;
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
