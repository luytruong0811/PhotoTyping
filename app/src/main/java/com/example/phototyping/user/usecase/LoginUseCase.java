package com.example.phototyping.user.usecase;

import android.app.Application;

import com.example.phototyping.user.database.UserRepository;

public class LoginUseCase {
    private UserRepository userRepository;

    public LoginUseCase(Application application) {
        userRepository = new UserRepository(application);
    }

    public boolean checkLogin(String email, String password) {
        return userRepository.checkLogin(email, password);
    }
}
