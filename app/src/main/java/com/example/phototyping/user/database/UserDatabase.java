package com.example.phototyping.user.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.phototyping.user.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract IUserDao userDao();
    private static final String DATABASE_NAME = "User.db";
    private static UserDatabase instance;

    public static synchronized UserDatabase getDatabase(Context context) {
        if(instance == null) {
            synchronized (UserDatabase.class){
                if(instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),UserDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
                }
            }
        }
        return instance;
    }
}
