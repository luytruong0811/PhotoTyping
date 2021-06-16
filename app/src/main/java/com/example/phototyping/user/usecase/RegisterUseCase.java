package com.example.phototyping.user.usecase;

import android.app.Application;

import com.example.phototyping.user.database.UserRepository;
import com.example.phototyping.user.model.User;

public class RegisterUseCase {
    private final UserRepository userRepository;

    public RegisterUseCase(Application application) {
        userRepository= new UserRepository(application);
    }

    public void insertUser(User user) { userRepository.insertUser(user); }
    public boolean  checkRegister(String email) {
        return userRepository.checkRegister(email);
    }
}
