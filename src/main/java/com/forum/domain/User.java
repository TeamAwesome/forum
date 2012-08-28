package com.forum.domain;


import com.forum.service.validation.Age;
import com.forum.service.validation.PhoneNumber;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class User {

    @NotEmpty
    private String username;

    @Size(min=8)
    private String password;

    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    private String email;

    @PhoneNumber
    private String phoneNumber;

    @NotEmpty
    private String country;

    @NotEmpty
    private String gender;

    @Age
    private int ageRange;

    @NotEmpty
    private List<String> interests;

    private List<String> knowledge;
    private Boolean privacy;

    public User(String username, String password, String name, String email, String phoneNumber,
                             String country, String gender, int ageRange) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.gender = gender;
        this.ageRange = ageRange;
        this.interests = interests;
        this.knowledge = knowledge;
        this.privacy = privacy;
    }

    public User() {
    }


    public List<String> getInterests() {
        return interests;
    }

    public List<String> getKnowledge() {
        return knowledge;
    }

    public Boolean getPrivacy() {
        return privacy;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAgeRange(int ageRange) {
        this.ageRange = ageRange;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public void setKnowledge(List<String> knowledge) {
        this.knowledge = knowledge;
    }

    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
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

    public int getAgeRange() {
        return ageRange;
    }
}
