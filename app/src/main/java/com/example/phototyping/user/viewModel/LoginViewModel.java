package com.example.phototyping.user.viewModel;

import android.app.Application;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.phototyping.user.usecase.LoginUseCase;

public class LoginViewModel extends ViewModel {
    LoginUseCase loginUsecase;
    private String email, passWord;
    private LoginListener loginListener;

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    public void onChangeUserName(String email) {
        this.email = email;
    }

    public void onChangePassWord(String passWord) {
        this.passWord = passWord;
    }

    public LoginViewModel(Application application) {
        loginUsecase = new LoginUseCase(application);
    }

    public int checkLogin(String email, String password) {
        if(loginUsecase.checkLogin(email, password)) {
            return 1;
        } else {
            if(email == null || passWord == null) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    public void login() {
        if(checkLogin(email, passWord) == 1) {
            loginListener.loginSuccess();
        } else {
            if(checkLogin(email, passWord) == 2) {
                loginListener.loginError("Information is null");
            } else {
                loginListener.loginError("Login failed");
            }
        }
    }

    public interface LoginListener {
        void loginError(String message);
        void loginSuccess();
    }
}
