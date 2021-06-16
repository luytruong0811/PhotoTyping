package com.example.phototyping.user.viewModel;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.example.phototyping.user.model.User;
import com.example.phototyping.user.usecase.RegisterUseCase;

public class RegisterViewModel extends ViewModel {
    RegisterUseCase registerUseCase;
    private String email, passWord, configPassWord;
    private RegisterListener registerListener;

    public void setRegisterListener(RegisterListener registerListener) {
        this.registerListener = registerListener;
    }

    public void onChangeUserName(String email) {
        this.email = email;
    }

    public void onChangePassWord(String passWord) {
        this.passWord = passWord;
    }

    public void onChangeConfigPassWord(String configPassWord) {
        this.configPassWord = configPassWord;
    }

    public RegisterViewModel(Application application) {
        registerUseCase = new RegisterUseCase(application);
    }

    public int checkRegister(String email) {
        if(registerUseCase.checkRegister(email)) {
            return 1;
        } else {
            if(email == null || passWord == null || configPassWord == null) {
                return 2;
            } else {
                if(!passWord.equals(configPassWord)) {
                    return 3;
                } else {
                    return 4;
                }
            }
        }
    }

    public void register() {
        if(checkRegister(email)==1) {
            registerListener.registerError("Account already exists");
        } else {
            if(checkRegister(email)==2) {
                registerListener.registerError("Information is null");
            } else {
                if(checkRegister(email)==3) {
                    registerListener.registerError("ConfigPassword is wrong");
                } else {
                    registerUseCase.insertUser(new User(email, passWord));
                    registerListener.registerSuccess();
                }
            }
        }
    }

    public interface RegisterListener {
        void registerError(String message);
        void registerSuccess();
    }
}
