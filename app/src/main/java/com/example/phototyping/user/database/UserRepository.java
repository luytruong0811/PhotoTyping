package com.example.phototyping.user.database;

import android.app.Application;

import com.example.phototyping.user.model.User;

public class UserRepository {
    public IUserDao iUserDao;
    public UserDatabase userDatabase;
    public UserRepository(Application application) {
        userDatabase = UserDatabase.getDatabase(application);
        iUserDao = userDatabase.userDao();
    }

    public void deleteUser() {
        iUserDao.deleteUser();
    }
    public void insertUser(final User user) {
        iUserDao.insertUser(user);
    }

    public boolean checkLogin(String userName, String password) {
        return iUserDao.checkLogin(userName,password) != null;
    }

    public boolean checkRegister(String email) {
        return iUserDao.checkRegister(email) != null;
    }
    public static User newUser(String email, String password) {
        User user = new User(email,password);
        return user;
    }
}
