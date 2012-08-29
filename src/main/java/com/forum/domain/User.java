package com.forum.domain;


import com.forum.service.validation.Age;
import com.forum.service.validation.PhoneNumber;
import com.forum.service.validation.UniqueEmail;
import com.forum.service.validation.UniqueUsername;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class User {

    @NotEmpty
    @UniqueUsername
    private String username;

    @Size(min=8)
    private String password;

    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    @UniqueEmail
    private String email;

    @PhoneNumber
    private String phoneNumber;

    @NotEmpty
    private String country;

    @NotEmpty
    private String gender;

    @Age
    private Integer ageRange;

    @NotEmpty
    private List<Integer> interests;

    private List<Integer> knowledge;
    private Boolean privacy;

    public User(String username, String password, String name, String email, String phoneNumber,
                             String country, String gender, Integer ageRange) {
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


    public List<Integer> getInterests() {
        return interests;
    }

    public List<Integer> getKnowledge() {
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

    public void setAgeRange(Integer ageRange) {
        this.ageRange = ageRange;
    }

    public void setInterests(List<Integer> interests) {
        this.interests = interests;
    }

    public void setKnowledge(List<Integer> knowledge) {
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

    public Integer getAgeRange() {
        return ageRange;
    }
}
