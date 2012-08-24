package com.forum.service;

import com.forum.domain.User;
import com.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(int id) {
        return userRepository.getById(id);
    }
}
