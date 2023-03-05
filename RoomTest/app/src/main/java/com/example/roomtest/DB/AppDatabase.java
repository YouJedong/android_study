package com.example.roomtest.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomtest.DAO.ImageDao;
import com.example.roomtest.DAO.UserDao;
import com.example.roomtest.VO.ImageUrl;
import com.example.roomtest.VO.User;

@Database(entities = {User.class, ImageUrl.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;
    public abstract UserDao userDao();
    public abstract ImageDao imageDao();

    public static AppDatabase getAppDatabase(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "ListInfo-db").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }


}
