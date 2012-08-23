package com.forum.service;

import com.forum.repository.AdminRepository;

public class AdminService {
    private AdminRepository adminRespository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRespository = adminRepository;
    }

    public Integer getTotalNumberOfQuestions() {
        return adminRespository.getAllQuestions().size();
    }
}
