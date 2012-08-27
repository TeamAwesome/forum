package com.forum.service;

import com.forum.domain.Country;
import com.forum.domain.User;
import com.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(int id) {
        return userRepository.getById(id);
    }

    public List<Country> getAvailableCountries() {
        List<Country> countries = new ArrayList<Country>();
        Scanner scanner = null;
        InputStream countriesInputStream = UserService.class.getClassLoader().getResourceAsStream("countries");
        scanner = new Scanner(countriesInputStream);
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            Country country = new Country(string, string);
            countries.add(country);
        }
        scanner.close();
        return countries;
    }
}
